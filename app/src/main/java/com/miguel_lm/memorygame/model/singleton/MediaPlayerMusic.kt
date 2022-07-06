package com.miguel_lm.memorygame.model.singleton

import android.media.MediaPlayer

class MediaPlayerMusic {

    private var instance: MediaPlayer? = null

    //Instance MediaPlayer
    fun getInstance(): MediaPlayer? {
        if (instance == null) {
            instance = MediaPlayer()
        }
        return instance
    }
}