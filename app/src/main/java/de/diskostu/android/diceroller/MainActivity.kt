package de.diskostu.android.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // apparently, and no one told me that, we don't have to use "findViewById". Instead, we can access the
        // view directly by using the id given in the layout file.
        // see https://antonioleiva.com/kotlin-android-extensions/ for more info on that
        roll_button.setOnClickListener {
            rollDice()
        }
    }


    private fun rollDice() {
        val drawableResource = when (val randomNumber = Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> throw IllegalStateException("The number $randomNumber should not happen here.")
        }

        dice_image.setImageResource(drawableResource)
    }
}