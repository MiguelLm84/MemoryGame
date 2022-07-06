package com.miguel_lm.memorygame.model.timer

import android.annotation.SuppressLint
import android.content.Context
import android.os.CountDownTimer
import android.view.View
import com.miguel_lm.memorygame.databinding.ActivityGameBinding
import com.miguel_lm.memorygame.model.dialog.DialogGameOver
import com.miguel_lm.memorygame.ui.activity.GameActivity
import com.miguel_lm.memorygame.ui.interfaces.ScoreGame

class Timer: ScoreGame {

    private var timer: CountDownTimer? = null
    private var blocking = false
    var scoreGame = 0

        //Method to start the timer
    @SuppressLint("SetTextI18n")
    fun initCountDown(binding: ActivityGameBinding, milliseconds: Long, context: Context) {

        timer?.cancel()

        timer = object : CountDownTimer(milliseconds, 1000) {

            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {

                val secondsRemaining = millisUntilFinished / 1000
                binding.tvTimer.text = secondsRemaining.toString() + "s"
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {

                blocking = true
                if(binding.tvTimer.visibility == View.INVISIBLE){
                    binding.tvTimer2.visibility = View.VISIBLE
                    showDialogGame(-1, context, binding)

                } else {
                    scoreGame = binding.tvPairs.text.toString().toInt()
                    showDialogGame(scoreGame, context, binding)
                }
            }
        }.start()
    }

    //Method to cancel the timer
    fun cancelTimer() {

        timer?.cancel()
    }

    //Method to show the dialog at the end of the game
    fun showDialogGame(score: Int, context: Context, binding: ActivityGameBinding) {

        if (!GameActivity().isFinishing) {
            DialogGameOver().showDialogGameOver(scoreCount(score), context)
            binding.constraintLayoutBoard.isClickable = false
        }
    }

    //Overridden method of the 'Timer' Interface to retrieve the score achieved and show it in the dialog
    override fun scoreCount(scoreTotal: Int): Int {

        return scoreTotal
    }
}