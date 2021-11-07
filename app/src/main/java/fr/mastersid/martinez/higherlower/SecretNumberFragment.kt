package fr.mastersid.martinez.higherlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import fr.mastersid.martinez.higherlower.databinding.FragmentSecretNumberBinding
import java.lang.NumberFormatException

class SecretNumberFragment(): Fragment() {
    private lateinit var _binding: FragmentSecretNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecretNumberBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: SecretNumberFragmentArgs by navArgs()
        val secretNumberModel: SecretNumberModel by viewModels(
                factoryProducer = { SecretNumberModelFactory(this, args.max, args.turns)})

        _binding.buttonChooseSn.setOnClickListener {
            secretNumberModel.chooseSecretNumber()
            secretNumberModel.resetTurns()
        }

        _binding.buttonCheck.setOnClickListener {
            if (secretNumberModel.secretNumber.value==SecretNumberModel.NO_SECRET_NUMBER){
                Toast
                    .makeText(this.context, getString(R.string.toast_choose_number), Toast.LENGTH_LONG)
                    .show()
            } else
                try {
                    secretNumberModel.check(_binding.edittextGuessSn.text.toString().toInt())
                } catch (e: NumberFormatException) {
                    Toast
                        .makeText(this.context, getString(R.string.toast_incorrect_number), Toast.LENGTH_LONG)
                        .show()
                }
        }

        secretNumberModel.remainingTurns.observe(viewLifecycleOwner){
            _binding.textviewRemainTurns.text=getString(R.string.textview_remaining_turns, secretNumberModel.remainingTurns.value)
            if (secretNumberModel.remainingTurns.value==0) {
                _binding.textviewLost.text=getString(R.string.textview_lost, secretNumberModel.secretNumber.value)
                _binding.textviewLost.visibility=View.VISIBLE
                _binding.buttonCheck.isEnabled=false
            } else {
                _binding.textviewLost.visibility = View.INVISIBLE
                _binding.buttonCheck.isEnabled = true
            }
        }

        secretNumberModel.secretNumber.observe(viewLifecycleOwner){
            when (secretNumberModel.secretNumber.value){
                SecretNumberModel.NO_SECRET_NUMBER ->{
                    _binding.textviewRemainTurns.visibility=View.INVISIBLE
                    _binding.textviewChosenSn.visibility=View.INVISIBLE
                }

                else -> {
                    _binding.textviewRemainTurns.visibility=View.VISIBLE
                    _binding.textviewChosenSn.visibility=View.VISIBLE
                }
            }
        }

        secretNumberModel.checkresult.observe(viewLifecycleOwner){
            when (secretNumberModel.checkresult.value){
                SecretNumberModel.CheckResult.GREATER -> {
                    _binding.textviewHilo.visibility=View.VISIBLE
                    _binding.textviewHilo.text=getString(R.string.textview_hilo_greater)
                }

                SecretNumberModel.CheckResult.LOWER -> {
                    _binding.textviewHilo.visibility=View.VISIBLE
                    _binding.textviewHilo.text=getString(R.string.textview_hilo_lower)
                }

                SecretNumberModel.CheckResult.EQUAL -> {
                    _binding.textviewHilo.visibility=View.VISIBLE
                    _binding.textviewHilo.text=getString(R.string.textview_hilo_equals)
                }

                SecretNumberModel.CheckResult.NO_GUESS -> {
                    _binding.textviewHilo.visibility=View.INVISIBLE
                    _binding.textviewHilo.text=getString(R.string.textview_hilo)
                }
            }
        }
    }
}
