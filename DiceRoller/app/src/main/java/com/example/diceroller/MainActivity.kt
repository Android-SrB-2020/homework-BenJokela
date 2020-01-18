package com.example.diceroller

import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        diceImage = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener{ clearApp() }
//        val countButton: Button = findViewById(R.id.countup_button)
//        countButton.setOnClickListener { countUp() }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "In onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "In onPause")

    }

    override fun onResume(){
        super.onResume()
        Log.d(TAG, "In onResume")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "In onRestart")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "In onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "In onDestroy")

    }


    private fun clearApp() {
        diceImage.setImageResource(R.drawable.empty_dice)
        dice2_image.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice() {

        diceImage.setImageResource(getRandomDiceImage())
        dice2_image.setImageResource(getRandomDiceImage())

    }

    private fun getRandomDiceImage() : Int {
//        val randomInt = Random().nextInt(6) + 1

        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

    }
//    private fun countUp() {
//        val resultText: TextView = findViewById(R.id.result_text)
//
//        // If text is the default "Hello World!" set that text to 1.
//        if (resultText.text == "Hello World!") {
//            resultText.text = "1"
//        } else {
//            // Otherwise, increment the number up to 6.
//            // The text value in resultText.text is an instance of the CharSequence class;
//            // it needs to be converted to a String object before it can be converted to an int.
//            var resultInt = resultText.text.toString().toInt()
//
//            if (resultInt < 6) {
//                resultInt++
//                resultText.text = resultInt.toString()
//            }
//        }
//    }
}
