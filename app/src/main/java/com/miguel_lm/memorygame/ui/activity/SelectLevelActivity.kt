package com.miguel_lm.memorygame.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.miguel_lm.memorygame.R
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.EXTRA_SELECTION
import com.miguel_lm.memorygame.databinding.ActivitySelectLevelBinding

class SelectLevelActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectLevelBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        elementAnimation()

        binding.cardViewLow.setOnClickListener { goToGameScreen(1) }
        binding.cardViewMedium.setOnClickListener { goToGameScreen(2) }
        binding.cardViewHigh.setOnClickListener { goToGameScreen(3) }
    }


    private fun goToGameScreen(selection: Int) {

        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra(EXTRA_SELECTION, selection)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    //Método para la animación del logo de la app y splash.
    private fun elementAnimation() {
        val animCardView = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animTitle = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.cardViewLevel.animation = animCardView

        Handler(Looper.getMainLooper()).postDelayed({ run {
            binding.tvTitleGame.animation = animTitle
        } }, 4000)
    }
}