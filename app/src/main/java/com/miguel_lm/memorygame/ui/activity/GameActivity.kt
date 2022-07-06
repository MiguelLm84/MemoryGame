package com.miguel_lm.memorygame.ui.activity

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.miguel_lm.memorygame.R
import com.miguel_lm.memorygame.model.provider.StaticVariables.Companion.EXTRA_SELECTION
import com.miguel_lm.memorygame.databinding.ActivityGameBinding
import com.miguel_lm.memorygame.model.provider.ChargeBoard
import com.miguel_lm.memorygame.model.provider.ImageList
import com.miguel_lm.memorygame.model.provider.Levels
import com.miguel_lm.memorygame.model.provider.ShowImagesOnGameBoard


class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    /*private val boardLow = arrayOfNulls<ImageButton>(16)
    private val boardMedium = arrayOfNulls<ImageButton>(24)
    private val boardHigh = arrayOfNulls<ImageButton>(30)*/

    private var score = 0
    /*private var hits = 0
    private var numCount = 0*/

    //variables game
    //private var unorderedList = ArrayList<Int>()
    /*private var first: ImageButton? = null
    private var numberFirst: Int = 0
    private var numberSecond: Int = 0*/
    private var blocking = false
    //private val handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arguments()
    }

    override fun onStart() {
        super.onStart()
        arguments()
    }

    private fun arguments() {

        val extras = intent.extras
        if (null != extras) {
            when(extras.getInt(EXTRA_SELECTION)) {
                1 -> Levels().lowDifficult(binding)
                2 -> Levels().mediumDifficult(binding)
                3 -> Levels().highDifficult(binding)
            }
            initGame(extras)
        }
    }

    //Method to start Media Player
    private fun mediaPlayerInit() {

        mediaPlayer = MediaPlayer.create(this, MUSIC_ZEN)
        mediaPlayer?.start()
        mediaPlayer?.isLooping = true
        mediaPlayerBtn = MediaPlayer.create(this, SOUND_BUTTON)
    }

    private fun initGame(extra: Bundle) {

        initCountDown()
        buttonsEvents()
        ChargeBoard().chargeBoards(extra.getInt(EXTRA_SELECTION), binding, this)
    }

    private fun buttonsEvents() {

        binding.cardViewRestart.setOnClickListener {
            mediaPlayerBtn?.start()
            mediaPlayer?.stop()
            finish()
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        binding.cardViewExit.setOnClickListener {  startActivity(Intent(this, SelectLevelActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    /*private fun chargeBoards(option: Int) {

        when(option){
            1-> chargeBoardLow(option)
            2-> chargeBoardMedium(option)
            3-> chargeBoardHigh(option)
        }
    }*/

    /*private fun chargeBoardLow(option: Int) {

        val cbLow = ChargeBoard()
        cbLow.chargeBoardLow(boardLow, binding)
        loadImages(option)
        ShowImagesOnGameBoard().showPicturesOnBoard(option, boardLow, binding, this)
    }

    private fun chargeBoardMedium(option: Int) {

        val cbMedium = ChargeBoard()
        cbMedium.chargeBoardMedium(boardMedium, binding)
        loadImages(option)
        ShowImagesOnGameBoard().showPicturesOnBoard(option, boardMedium, binding, this)
    }

    private fun chargeBoardHigh(option: Int) {

        ChargeBoard().chargeBoardHigh(boardHigh, binding)
        loadImages(option)
        ShowImagesOnGameBoard().showPicturesOnBoard(option, boardHigh, binding, this)
    }*/

    /*private fun loadImages(option: Int) {

        when(option){
            1-> ImageList().imageListLow()
            2-> ImageList().imageListMedium()
            3-> ImageList().imageListHigh()
        }
    }*/

    /*private fun showPicturesOnBoard(option: Int) {

        when(option){
            1-> showPicturesOnBoardLow()
            2-> showPicturesOnBoardMedium()
            3-> showPicturesOnBoardHigh()
        }
    }

    private fun showPicturesOnBoardLow(){

        unorderedList = shuffleImages(ImageList().chargeListImageLow().size)
        for (i in boardLow.indices) {
            boardLow[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
            boardLow[i]?.setImageResource(ImageList().chargeListImageLow()[unorderedList[i]])
        }

        handler.postDelayed({
            for (i in boardLow.indices) {
                boardLow[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
                boardLow[i]?.setImageResource(BACKGROUND_ROW)
            }
        }, 500)

        for (i in boardLow.indices) {
            boardLow[i]?.isEnabled = true
            boardLow[i]?.setOnClickListener{ if(!blocking) boardLow[i]?.let { it1 -> check(i, it1) } }
        }
    }

    private fun showPicturesOnBoardMedium(){

        unorderedList = shuffleImages(ImageList().chargeListImageMedium().size)
        for (i in boardMedium.indices) {
            boardMedium[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
            boardMedium[i]?.setImageResource(ImageList().chargeListImageMedium()[unorderedList[i]])
        }

        handler.postDelayed({
            for (i in boardMedium.indices) {
                boardMedium[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
                boardMedium[i]?.setImageResource(BACKGROUND_ROW)
            }
        }, 500)

        for (i in boardMedium.indices) {
            boardMedium[i]?.isEnabled = true
            boardMedium[i]?.setOnClickListener{ if(!blocking) boardMedium[i]?.let { it1 -> check(i, it1) } }
        }
    }

    private fun showPicturesOnBoardHigh(){

        unorderedList = shuffleImages(ImageList().chargeListImageHigh().size)
        for (i in boardHigh.indices) {
            boardHigh[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
            boardHigh[i]?.setImageResource(ImageList().chargeListImageHigh()[unorderedList[i]])
        }

        handler.postDelayed({
            for (i in boardHigh.indices) {
                boardHigh[i]?.scaleType = ImageView.ScaleType.CENTER_CROP
                boardHigh[i]?.setImageResource(BACKGROUND_ROW)
            }
        }, 500)

        for (i in boardHigh.indices) {
            boardHigh[i]?.isEnabled = true
            boardHigh[i]?.setOnClickListener{ if(!blocking) boardHigh[i]?.let { it1 -> check(i, it1) } }
        }
    }*/

    /*@SuppressLint("SetTextI18n")
    private fun check(i: Int, imgb: ImageButton){


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

                if(hits == ImageList().imageListHigh.size) {
                    showDialogGame(score)
                    binding.tvTimer.text = "0s"
                    blocking = true
                    Toast.makeText(applicationContext,"Has ganado!!", Toast.LENGTH_SHORT).show()
                }

            } else {
                handler.postDelayed({
                    first!!.scaleType = ImageView.ScaleType.CENTER_CROP
                    first!!.setImageResource(BACKGROUND_ROW)
                    first!!.isEnabled = true
                    imgb.scaleType = ImageView.ScaleType.CENTER_CROP
                    imgb.setImageResource(BACKGROUND_ROW)
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
    }*/

    /*private fun shuffleImages(length: Int): ArrayList<Int> {

        val result: ArrayList<Int> = ArrayList()

        for (i in 0 until length * 2) {
            result.add(i % length)
        }
        result.shuffle()

        return result
    }*/
}