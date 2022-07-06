package com.miguel_lm.memorygame.model.provider

import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.PATRAT
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.BACKGROUND_ROW
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.BULBASUR
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.CHARMELEON
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.DRAGONAIR
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.EEVEE
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.JIGGLYPUFF
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.JOLTEON
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.MEW
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.MEWTWO
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.PIDGEOT
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.PIKACHU
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.PIOLIN
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.PIPLUP
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.PLUTO
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.PORKY
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.PSYDUCK
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.SNORLAX
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.SQUIRTLE
import com.miguel_lm.memorygame.ui.interfaces.ChargeList


class ImageList: ChargeList {

    var imageListLow = IntArray(8)
    var imageListMedium = IntArray(12)
    var imageListHigh = IntArray(15)

    fun imageListLow(){

        chargeListImageLow()
        BACKGROUND_ROW
    }

    fun imageListMedium(){

        chargeListImageMedium()
        BACKGROUND_ROW
    }

    fun imageListHigh(){

        chargeListImageHigh()
        BACKGROUND_ROW
    }

    override fun chargeListImageLow(): IntArray {

        imageListLow = intArrayOf(
            PIKACHU,
            EEVEE,
            CHARMELEON,
            JIGGLYPUFF,
            SQUIRTLE,
            PIPLUP,
            BULBASUR,
            MEWTWO)

        return imageListLow
    }

    override fun chargeListImageMedium(): IntArray {

        imageListMedium = intArrayOf(
            PIKACHU,
            EEVEE,
            CHARMELEON,
            JIGGLYPUFF,
            SQUIRTLE,
            PIPLUP,
            BULBASUR,
            MEWTWO,
            MEW,
            JOLTEON,
            PSYDUCK,
            SNORLAX)

        return imageListMedium
    }

    override fun chargeListImageHigh(): IntArray {

        imageListHigh = intArrayOf(
            PIKACHU,
            EEVEE,
            CHARMELEON,
            JIGGLYPUFF,
            SQUIRTLE,
            PIPLUP,
            BULBASUR,
            MEWTWO,
            MEW,
            JOLTEON,
            PSYDUCK,
            SNORLAX,
            PIDGEOT,
            PATRAT,
            DRAGONAIR)

        return imageListHigh
    }
}