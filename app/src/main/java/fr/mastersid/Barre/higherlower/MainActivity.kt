package fr.mastersid.Barre.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.mastersid.Barre.higherlower.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    private var secretNumber: String = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idChooseNumber.setOnClickListener {
            secretNumber = (1..100).random().toString()
            binding.idTextView1.text = "Secret number chosen"
            System.out.println("le nombre secret est "+secretNumber)
        }

        binding.idButtonCheck.setOnClickListener {
            when (secretNumber) {
                binding.idGuessNumber.text.toString() -> Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show()
                else -> { // Note the block
                    Toast.makeText(this, "incorect", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }




}