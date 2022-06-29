package com.miguel_lm.memorygame.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.Explode
import android.view.WindowManager
import com.miguel_lm.memorygame.R
import com.miguel_lm.memorygame.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = true
        }*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            //window.insetsController?.hide(WindowInsets.Type.statusBars())
           //window.insetsController?.hide(WindowInsets.Type.navigationBars())

            //window.insetsController?.hide(WindowInsets.Type.systemBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //animacionLogoSplash()
       //animacionTextoVersionSplashIn()
        splashTime()
    }

    //Método mostrar splash durante un tiempo determinado y después ir a la pantalla de login.
    private fun splashTime() {
        Handler(Looper.getMainLooper()).postDelayed({ startActivity(Intent(this, SelectLevelActivity::class.java)) }, 4000)
        val explode = Explode()
        explode.duration = 1500
        window.exitTransition = explode
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    //Método para animación del logo del juego.
    /*fun animacionLogoSplash() {
        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        iv_titulo.setAnimation(animacion1)
    }

    //Método para la animación del TextView de la versión.
    @RequiresApi(api = Build.VERSION_CODES.P)
    fun animacionTextoVersionSplashIn() {
        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.fade_in_2)
        tv_version.setAnimation(animacion2)
    }*/
}