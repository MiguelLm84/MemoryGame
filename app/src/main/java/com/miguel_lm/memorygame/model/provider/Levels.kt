package com.miguel_lm.memorygame.model.provider

import android.view.View
import com.miguel_lm.memorygame.databinding.ActivityGameBinding

class Levels {

    fun lowDifficult(binding: ActivityGameBinding) {

        binding.tableLayoutLow.visibility = View.VISIBLE
        binding.tableLayoutMedium.visibility = View.GONE
        binding.tableLayoutHigh.visibility = View.GONE
    }

    fun mediumDifficult(binding: ActivityGameBinding) {

        binding.tableLayoutLow.visibility = View.GONE
        binding.tableLayoutMedium.visibility = View.VISIBLE
        binding.tableLayoutHigh.visibility = View.GONE
    }

    fun highDifficult(binding: ActivityGameBinding) {

        binding.tableLayoutLow.visibility = View.GONE
        binding.tableLayoutMedium.visibility = View.GONE
        binding.tableLayoutHigh.visibility = View.VISIBLE
    }
}