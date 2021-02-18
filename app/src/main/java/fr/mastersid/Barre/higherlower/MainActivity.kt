package fr.mastersid.Barre.higherlower

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import fr.mastersid.Barre.higherlower.databinding.ActivityMainBinding

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
                    secretNumberModel.check(binding.idGuessNumber.text.toString().toInt())
                    if (secretNumberModel.checkResult.value.toString()=="EQUAL")
                        binding.idTextView2.text = "Well done"
                    if (secretNumberModel.checkResult.value.toString()=="GREATER")
                        binding.idTextView2.text = "The secret number is greater"
                    if (secretNumberModel.checkResult.value.toString()=="LOWER")
                        binding.idTextView2.text = "The secret number is lower"
                } catch (error: NumberFormatException) {
                    Toast.makeText(this, "Incorrect number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}