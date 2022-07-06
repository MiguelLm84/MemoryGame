package com.miguel_lm.memorygame.model.provider

import android.content.Context
import android.media.MediaPlayer
import android.widget.ImageButton
import com.miguel_lm.memorygame.R
import com.miguel_lm.memorygame.databinding.ActivityGameBinding
import com.miguel_lm.memorygame.model.timer.Timer


class ChargeBoard {

    private val boardLow = arrayOfNulls<ImageButton>(16)
    private val boardMedium = arrayOfNulls<ImageButton>(24)
    private val boardHigh = arrayOfNulls<ImageButton>(30)

    private fun chargeBoardLow(/*boardLow: Array<ImageButton?>, */binding: ActivityGameBinding) {

        boardLow[0] = binding.ivLow1.findViewById(R.id.iv_low_1)
        boardLow[1] = binding.ivLow2.findViewById(R.id.iv_low_2)
        boardLow[2] = binding.ivLow3.findViewById(R.id.iv_low_3)
        boardLow[3] = binding.ivLow4.findViewById(R.id.iv_low_4)

        boardLow[4] = binding.ivLow5.findViewById(R.id.iv_low_5)
        boardLow[5] = binding.ivLow6.findViewById(R.id.iv_low_6)
        boardLow[6] = binding.ivLow7.findViewById(R.id.iv_low_7)
        boardLow[7] = binding.ivLow8.findViewById(R.id.iv_low_8)

        boardLow[8] = binding.ivLow9.findViewById(R.id.iv_low_9)
        boardLow[9] = binding.ivLow10.findViewById(R.id.iv_low_10)
        boardLow[10] = binding.ivLow11.findViewById(R.id.iv_low_11)
        boardLow[11] = binding.ivLow12.findViewById(R.id.iv_low_12)

        boardLow[12] = binding.ivLow13.findViewById(R.id.iv_low_13)
        boardLow[13] = binding.ivLow14.findViewById(R.id.iv_low_14)
        boardLow[14] = binding.ivLow15.findViewById(R.id.iv_low_15)
        boardLow[15] = binding.ivLow16.findViewById(R.id.iv_low_16)
    }

    private fun chargeBoardMedium(/*boardMedium: Array<ImageButton?>, */binding: ActivityGameBinding) {

        boardMedium[0] = binding.ivMedium1.findViewById(R.id.iv_medium_1)
        boardMedium[1] = binding.ivMedium2.findViewById(R.id.iv_medium_2)
        boardMedium[2] = binding.ivMedium3.findViewById(R.id.iv_medium_3)
        boardMedium[3] = binding.ivMedium4.findViewById(R.id.iv_medium_4)

        boardMedium[4] = binding.ivMedium5.findViewById(R.id.iv_medium_5)
        boardMedium[5] = binding.ivMedium6.findViewById(R.id.iv_medium_6)
        boardMedium[6] = binding.ivMedium7.findViewById(R.id.iv_medium_7)
        boardMedium[7] = binding.ivMedium8.findViewById(R.id.iv_medium_8)

        boardMedium[8] = binding.ivMedium9.findViewById(R.id.iv_medium_9)
        boardMedium[9] = binding.ivMedium10.findViewById(R.id.iv_medium_10)
        boardMedium[10] = binding.ivMedium11.findViewById(R.id.iv_medium_11)
        boardMedium[11] = binding.ivMedium12.findViewById(R.id.iv_medium_12)

        boardMedium[12] = binding.ivMedium13.findViewById(R.id.iv_medium_13)
        boardMedium[13] = binding.ivMedium14.findViewById(R.id.iv_medium_14)
        boardMedium[14] = binding.ivMedium15.findViewById(R.id.iv_medium_15)
        boardMedium[15] = binding.ivMedium16.findViewById(R.id.iv_medium_16)

        boardMedium[16] = binding.ivMedium17.findViewById(R.id.iv_medium_17)
        boardMedium[17] = binding.ivMedium18.findViewById(R.id.iv_medium_18)
        boardMedium[18] = binding.ivMedium19.findViewById(R.id.iv_medium_19)
        boardMedium[19] = binding.ivMedium20.findViewById(R.id.iv_medium_20)

        boardMedium[20] = binding.ivMedium21.findViewById(R.id.iv_medium_21)
        boardMedium[21] = binding.ivMedium22.findViewById(R.id.iv_medium_22)
        boardMedium[22] = binding.ivMedium23.findViewById(R.id.iv_medium_23)
        boardMedium[23] = binding.ivMedium24.findViewById(R.id.iv_medium_24)
    }

    private fun chargeBoardHigh(/*boardHigh: Array<ImageButton?>,*/ binding: ActivityGameBinding) {

        boardHigh[0] = binding.ivHigh1.findViewById(R.id.iv_high_1)
        boardHigh[1] = binding.ivHigh2.findViewById(R.id.iv_high_2)
        boardHigh[2] = binding.ivHigh3.findViewById(R.id.iv_high_3)
        boardHigh[3] = binding.ivHigh4.findViewById(R.id.iv_high_4)

        boardHigh[4] = binding.ivHigh5.findViewById(R.id.iv_high_5)
        boardHigh[5] = binding.ivHigh6.findViewById(R.id.iv_high_6)
        boardHigh[6] = binding.ivHigh7.findViewById(R.id.iv_high_7)
        boardHigh[7] = binding.ivHigh8.findViewById(R.id.iv_high_8)

        boardHigh[8] = binding.ivHigh9.findViewById(R.id.iv_high_9)
        boardHigh[9] = binding.ivHigh10.findViewById(R.id.iv_high_10)
        boardHigh[10] = binding.ivHigh11.findViewById(R.id.iv_high_11)
        boardHigh[11] = binding.ivHigh12.findViewById(R.id.iv_high_12)

        boardHigh[12] = binding.ivHigh13.findViewById(R.id.iv_high_13)
        boardHigh[13] = binding.ivHigh14.findViewById(R.id.iv_high_14)
        boardHigh[14] = binding.ivHigh15.findViewById(R.id.iv_high_15)
        boardHigh[15] = binding.ivHigh16.findViewById(R.id.iv_high_16)

        boardHigh[16] = binding.ivHigh17.findViewById(R.id.iv_high_17)
        boardHigh[17] = binding.ivHigh18.findViewById(R.id.iv_high_18)
        boardHigh[18] = binding.ivHigh19.findViewById(R.id.iv_high_19)
        boardHigh[19] = binding.ivHigh20.findViewById(R.id.iv_high_20)

        boardHigh[20] = binding.ivHigh21.findViewById(R.id.iv_high_21)
        boardHigh[21] = binding.ivHigh22.findViewById(R.id.iv_high_22)
        boardHigh[22] = binding.ivHigh23.findViewById(R.id.iv_high_23)
        boardHigh[23] = binding.ivHigh24.findViewById(R.id.iv_high_24)

        boardHigh[24] = binding.ivHigh25.findViewById(R.id.iv_high_25)
        boardHigh[25] = binding.ivHigh26.findViewById(R.id.iv_high_26)
        boardHigh[26] = binding.ivHigh27.findViewById(R.id.iv_high_27)
        boardHigh[27] = binding.ivHigh28.findViewById(R.id.iv_high_28)

        boardHigh[28] = binding.ivHigh29.findViewById(R.id.iv_high_29)
        boardHigh[29] = binding.ivHigh30.findViewById(R.id.iv_high_30)
    }

     fun chargeBoards(option: Int/*, board: Array<ImageButton?>, */, binding: ActivityGameBinding, context: Context) {

        when(option){
            1-> chargeBoardLow(option, binding, context)
            2-> chargeBoardMedium(option, binding, context)
            3-> chargeBoardHigh(option, binding, context)
        }
    }

    private fun chargeBoardLow(option: Int/*, board: Array<ImageButton?>, */, binding: ActivityGameBinding, context: Context) {

        chargeBoardLow(binding)
        loadImages(option)
        ShowImagesOnGameBoard().showPicturesOnBoard(option, boardLow, binding, context)
    }

    private fun chargeBoardMedium(option: Int/*, board: Array<ImageButton?>, */, binding: ActivityGameBinding, context: Context) {

        chargeBoardMedium(binding)
        loadImages(option)
        ShowImagesOnGameBoard().showPicturesOnBoard(option, boardMedium, binding, context)
    }

    private fun chargeBoardHigh(option: Int/*, board: Array<ImageButton?>, */, binding: ActivityGameBinding, context: Context) {

        chargeBoardHigh(binding)
        loadImages(option)
        ShowImagesOnGameBoard().showPicturesOnBoard(option, boardHigh, binding, context)
    }

    private fun loadImages(option: Int) {

        when(option){
            1-> ImageList().imageListLow()
            2-> ImageList().imageListMedium()
            3-> ImageList().imageListHigh()
        }
    }
}