package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button= findViewById(R.id.button)

        //activity when the button is pressed
        rollButton.setOnClickListener{

            rollDice()

            //pop up msg for a short time
            val toast:Toast  = Toast.makeText(this, "Dice Rolled, you happy now?", Toast.LENGTH_SHORT)
            toast.show()
        }
        //roll the dice before the button preseseed
        rollDice()
    }
    /**
     * the roll dice private function
     */
    private fun rollDice() {
            val dice = Dice(6)

        //create variable and search for the element from the app
            val diceImage: ImageView = findViewById(R.id.imageView)

        //printing out the rollDice number
        val diceRoll = dice.roll()
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }


        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int){
    fun roll(): Int {

        return (1..numSides).random()
    }
}