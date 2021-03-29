package fr.mastersid.Barre.higherlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import fr.mastersid.Barre.higherlower.databinding.FragmentSettingsBinding

/**
 *Created by Bryan BARRE on 08/03/2021.
 */
class SettingsFragment:Fragment() {
    private lateinit var _binding : FragmentSettingsBinding
    override fun onCreateView (
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated (view : View, savedInstanceState : Bundle?) {
        super.onViewCreated (view , savedInstanceState )
        val settingsModel: SettingsModel by viewModels(factoryProducer = {SettingsModelFactory(context)})

        _binding.idPlay.setOnClickListener {
            try {
                val turns = _binding.idTurns.text.toString().toInt()
                val max = _binding.idSecretNumbeMaxValue.text.toString().toInt()
                val action = SettingsFragmentDirections.actionSettingsFragmentToSecretNumberFragment(turns,max)
                findNavController().navigate(action)
            }
            catch (error: NumberFormatException) {
                Toast.makeText(this.context, "Incorrect number", Toast.LENGTH_SHORT).show()
            }
        }

        _binding.saveValue.setOnClickListener {
            try {
                val turns = _binding.idTurns.text.toString().toInt()
                val max = _binding.idSecretNumbeMaxValue.text.toString().toInt()
                settingsModel.save(turns,max)
            }catch (error: NumberFormatException) {
                Toast.makeText(this.context, "Incorrect number", Toast.LENGTH_SHORT).show()
            }
        }

        settingsModel.favorite.observe(viewLifecycleOwner){
            value ->
            if ( value != SettingsModel.NO_VALUE1 && _binding.idTurns.text.toString().isEmpty()) {
                _binding.idTurns.setText("$value")
            }
        }
        settingsModel.favorite2.observe(viewLifecycleOwner){
            value ->
            if ( value != SettingsModel.NO_VALUE2 && _binding.idSecretNumbeMaxValue.text.toString().isEmpty()) {
                _binding.idSecretNumbeMaxValue.setText("$value")
            }
        }
    }
}

