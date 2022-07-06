package com.miguel_lm.memorygame.model.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.miguel_lm.memorygame.R
import com.miguel_lm.memorygame.model.singleton.MediaPlayerMusic
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.MUSIC_LOOSE
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.MUSIC_WINNER
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.SOUND_LOOSER

class DialogGameOver {

    private var mediaPlayer = MediaPlayerMusic().getInstance()


    //Method to show dialog at the end of the game
    @SuppressLint("SetTextI18n")
    fun showDialogGameOver(totalScore: Int, context: Context) {

        val builder = AlertDialog.Builder(context)
        val dialogLayout: View = LayoutInflater.from(context).inflate(R.layout.dialog_game_over, null)
        builder.setView(dialogLayout)
        val dialog = builder.create()
        val lottieDialog = dialogLayout.findViewById<LottieAnimationView>(R.id.lottie_dialog)
        val tvPoints = dialogLayout.findViewById<TextView>(R.id.tv_puntos)
        val tvInfo = dialogLayout.findViewById<TextView>(R.id.tv_info)
        val btnAccept = dialogLayout.findViewById<Button>(R.id.btn_aceptar)

        when (totalScore) {
            in 4..7 -> {
                tvInfo.text = "NO HA ESTADO MAL!!\n Has conseguido $totalScore parejas!!"
                tvPoints.text = "$totalScore puntos"
                lottieDialog.setAnimation("congratulation.json")
            }
            in 1..3 -> {
                tvInfo.text = "HAS ESTADO FLOJITO...\n Has conseguido $totalScore parejas!!"
                tvPoints.text = "$totalScore puntos"
                lottieDialog.setAnimation("congratulation.json")
            }
            8 -> {
                tvInfo.text = "HAS GANADO!!!\n Enhorabuena, Has aceratdo todas las parejas!!"
                tvPoints.text = "8 puntos"
            }
            0 -> {
                tvInfo.text = "SORRY, HAS PERDIDO!!\n No has acertado ninguna pareja"
                tvPoints.text = "0 puntos"
                lottieDialog.setAnimation("thumbs_down.json")
                lottieDialog.rotation = 180f
            }
        }

        lottieDialog.playAnimation()

        btnAccept.setOnClickListener { dialog.dismiss() }
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }
}