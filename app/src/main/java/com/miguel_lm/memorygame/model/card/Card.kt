package com.miguel_lm.memorygame.model.card

import android.widget.ImageView

class Card(iv_imageCard: ImageView, iv_foregroundImage: ImageView, isForegroundImageHidden: Boolean) {

    private var ivImageCard: ImageView ? = iv_imageCard
    private var ivForegroundImage: ImageView ? = iv_foregroundImage
    private var isForegroundImageHidden: Boolean = isForegroundImageHidden
}