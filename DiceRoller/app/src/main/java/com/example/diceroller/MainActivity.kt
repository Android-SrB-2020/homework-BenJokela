package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

    private fun clearApp() {
        diceImage.setImageResource(R.drawable.empty_dice)
        dice2_image.setImageResource(R.drawable.empty_dice)
    }

    private fun rollDice() {

        diceImage.setImageResource(getRandomDiceImage())
        dice2_image.setImageResource(getRandomDiceImage())

    }

    private fun getRandomDiceImage() : Int {
        val randomInt = Random().nextInt(6) + 1

        return when (randomInt) {
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
