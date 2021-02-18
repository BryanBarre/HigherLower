package fr.mastersid.Barre.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import fr.mastersid.Barre.higherlower.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  secretNumberModel: SecretNumberModel by viewModels()

        binding.idChooseNumber.setOnClickListener {
            secretNumberModel.chooseSecretNumber()
            binding.idTextView1.text = "Secret number chosen"
        }

        binding.idButtonCheck.setOnClickListener {
            if (secretNumberModel.secretNumber.value.toString()=="-1") {
                Toast.makeText(this, "First  press  \"Choose  secretnumber\"  button", Toast.LENGTH_SHORT).show()
            }
            else {
                try {
                    System.out.println("------le nombre choisie est " + binding.idGuessNumber.text.toString().toInt())
                    System.out.println("------le nombre secret est "+secretNumberModel.secretNumber.value)
                    secretNumberModel.Check(binding.idGuessNumber.text.toString().toInt())
                    if (secretNumberModel.checkResult.value.toString()=="EQUAL")
                        binding.idTextView2.setText("Well done")
                    if (secretNumberModel.checkResult.value.toString()=="GREATER")
                        binding.idTextView2.setText("The secret number is greater")
                    if (secretNumberModel.checkResult.value.toString()=="LOWER")
                        binding.idTextView2.setText("The secret number is lower")
                } catch (error: NumberFormatException) {
                    Toast.makeText(this, "Incorrect number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}