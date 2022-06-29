package com.miguel_lm.memorygame.model.provider

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.miguel_lm.memorygame.databinding.ActivityGameBinding
import com.miguel_lm.memorygame.model.dialog.DialogGameOver

class ShowImagesOnGameBoard {

    private var unorderedList = ArrayList<Int>()
    private val handler = Handler(Looper.getMainLooper())
    private var blocking = false
    private var first: ImageButton? = null
    private var numberFirst: Int = 0
    private var numberSecond: Int = 0
    private var hits = 0
    private var numCount = 0
    private var score = 0


    fun showPicturesOnBoard(option: Int, board: Array<ImageButton?>,
                            binding: ActivityGameBinding, context: Context) {

        when(option){
            1-> showPicturesOnBoardLow(board, binding, context)
            2-> showPicturesOnBoardMedium(board, binding, context)
            3-> showPicturesOnBoardHigh(board, binding, context)
        }
    }

    private fun showPicturesOnBoardLow(boardLow: Array<ImageButton?>,
                                       binding: ActivityGameBinding, context: Context){

        unorderedList = shuffleImages(ImageList().chargeListImageLow().size)
        for (i in boardLow.indices) {
            boardLow[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
            boardLow[i]?.setImageResource(ImageList().chargeListImageLow()[unorderedList[i]])
        }

        handler.postDelayed({
            for (i in boardLow.indices) {
                boardLow[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
                boardLow[i]?.setImageResource(StaticVariables.BACKGROUND_ROW)
            }
        }, 500)

        for (i in boardLow.indices) {
            boardLow[i]?.isEnabled = true
            boardLow[i]?.setOnClickListener{ if(!blocking) boardLow[i]?.let {
                    it1 -> check(i, it1, binding, context) } }
        }
    }

    private fun showPicturesOnBoardMedium(boardMedium: Array<ImageButton?>,
                                          binding: ActivityGameBinding, context: Context){

        unorderedList = shuffleImages(ImageList().chargeListImageMedium().size)
        for (i in boardMedium.indices) {
            boardMedium[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
            boardMedium[i]?.setImageResource(ImageList().chargeListImageMedium()[unorderedList[i]])
        }

        handler.postDelayed({
            for (i in boardMedium.indices) {
                boardMedium[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
                boardMedium[i]?.setImageResource(StaticVariables.BACKGROUND_ROW)
            }
        }, 500)

        for (i in boardMedium.indices) {
            boardMedium[i]?.isEnabled = true
            boardMedium[i]?.setOnClickListener{ if(!blocking) boardMedium[i]?.let {
                    it1 -> check(i, it1, binding, context) } }
        }
    }

    private fun showPicturesOnBoardHigh(boardHigh: Array<ImageButton?>,
                                        binding: ActivityGameBinding, context: Context){

        unorderedList = shuffleImages(ImageList().chargeListImageHigh().size)
        for (i in boardHigh.indices) {
            boardHigh[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
            boardHigh[i]?.setImageResource(ImageList().chargeListImageHigh()[unorderedList[i]])
        }

        handler.postDelayed({
            for (i in boardHigh.indices) {
                boardHigh[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
                boardHigh[i]?.setImageResource(StaticVariables.BACKGROUND_ROW)
            }
        }, 500)

        for (i in boardHigh.indices) {
            boardHigh[i]?.isEnabled = true
            boardHigh[i]?.setOnClickListener{ if(!blocking) boardHigh[i]?.let {
                    it1 -> check(i, it1, binding, context) } }
        }
    }

    private fun shuffleImages(length: Int): ArrayList<Int> {

        val result: ArrayList<Int> = ArrayList()

        for (i in 0 until length * 2) {
            result.add(i % length)
        }
        result.shuffle()

        return result
    }

    @SuppressLint("SetTextI18n")
    private fun check(i: Int, imgb: ImageButton, binding: ActivityGameBinding, context: Context){

        if(first == null){
            first = imgb
            first!!.scaleType = ImageView.ScaleType.CENTER_CROP
            first!!.setImageResource(ImageList().chargeListImageHigh()[unorderedList[i]])
            first!!.isEnabled = false
            numberFirst = unorderedList[i]
            numCount++
            binding.tvCounter.text = numCount.toString()

        } else {
            blocking = true
            imgb.scaleType = ImageView.ScaleType.CENTER_CROP
            imgb.setImageResource(ImageList().chargeListImageHigh()[unorderedList[i]])
            imgb.isEnabled = false
            numberSecond = unorderedList[i]
            numCount++
            binding.tvCounter.text = numCount.toString()

            if(numberFirst == numberSecond){
                first = null
                blocking = false
                hits++
                score++
                binding.tvPairs.text = score.toString()
                binding.tvCounter.text = numCount.toString()

                if(hits == ImageList().chargeListImageLow().size) {
                    DialogGameOver().showDialogGameOver(score, context)
                    binding.tvTimer.text = "0s"
                    blocking = true
                    Toast.makeText(context,"Has ganado!!", Toast.LENGTH_SHORT).show()
                }

            } else {
                handler.postDelayed({
                    first!!.scaleType = ImageView.ScaleType.CENTER_CROP
                    first!!.setImageResource(StaticVariables.BACKGROUND_ROW)
                    first!!.isEnabled = true
                    imgb.scaleType = ImageView.ScaleType.CENTER_CROP
                    imgb.setImageResource(StaticVariables.BACKGROUND_ROW)
                    imgb.isEnabled = true
                    blocking = false
                    first = null
                    if (score > 0) {
                        score--
                    }
                    binding.tvPairs.text = score.toString()
                }, 1000)
            }
        }
    }
}