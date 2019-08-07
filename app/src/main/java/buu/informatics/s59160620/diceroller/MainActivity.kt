package buu.informatics.s59160620.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
//import kotlin.random.Random
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "Dice Rolled!"
        rollButton.setOnClickListener { rollDice() }

        val reButton: Button = findViewById(R.id.re_button)
        reButton.setOnClickListener{ reset() }


    }

    private fun rollDice() {

        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        val randomInt = Random().nextInt(6) + 1
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()

        val diceImage: ImageView = findViewById(R.id.dice_image)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }

    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(R.drawable.empty_dice)
    }

}

