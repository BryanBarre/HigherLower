package fr.mastersid.Barre.higherlower;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import fr.mastersid.Barre.higherlower.databinding.FragmentSecretnumberBinding

/**
 * Created by Bryan BARRE on 08/03/2021.
 */
class SecretNumberFragment: Fragment() {
    private lateinit var _binding : FragmentSecretnumberBinding
    override fun onCreateView (
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ): View? {
        _binding = FragmentSecretnumberBinding.inflate(inflater)
        return _binding.root
    }
    override fun onViewCreated ( view : View , savedInstanceState : Bundle ?) {
        super.onViewCreated (view , savedInstanceState )

        val  secretNumberModel: SecretNumberModel by viewModels()

        _binding.idChooseNumber.setOnClickListener {
            secretNumberModel.chooseSecretNumber()
            _binding.idTextView1.text = "Secret number chosen"
        }
        _binding.idButtonCheck.setOnClickListener {
            if (secretNumberModel.secretNumber.value.toString()=="-1") {
                Toast.makeText(this.context, "First  press  \"Choose  secretnumber\"  button", Toast.LENGTH_SHORT).show()
            }
            else {
                try {
                    secretNumberModel.check(_binding.idGuessNumber.text.toString().toInt())
                    if (secretNumberModel.checkResult.value.toString()=="EQUAL")
                        _binding.idTextView2.text = "Well done"
                    if (secretNumberModel.checkResult.value.toString()=="GREATER")
                        _binding.idTextView2.text = "The secret number is greater"
                    if (secretNumberModel.checkResult.value.toString()=="LOWER")
                        _binding.idTextView2.text = "The secret number is lower"
                } catch (error: NumberFormatException) {
                    Toast.makeText(this.context, "Incorrect number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
/*

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
 */
