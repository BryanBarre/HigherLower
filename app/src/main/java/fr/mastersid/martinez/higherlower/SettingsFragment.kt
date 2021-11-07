package fr.mastersid.martinez.higherlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import fr.mastersid.martinez.higherlower.databinding.FragmentSettingsBinding
import java.lang.NumberFormatException

class SettingsFragment: Fragment() {
    private lateinit var _binding: FragmentSettingsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val settingsModel: SettingsModel by viewModels(factoryProducer = {SettingsModelFactory(context)})

        settingsModel.maxFavorite.observe(viewLifecycleOwner) {
            if ( settingsModel.maxFavorite.value != SettingsModel.NO_VALUE && _binding.edittextMaxNumber.text.isEmpty()) {
                _binding.edittextMaxNumber.setText(settingsModel.maxFavorite.value.toString())
            }
        }

        settingsModel.turnsFavorite.observe(viewLifecycleOwner) {
            if ( settingsModel.turnsFavorite.value != SettingsModel.NO_VALUE && _binding.edittextTurnsNumber.text.isEmpty()) {
                _binding.edittextTurnsNumber.setText(settingsModel.turnsFavorite.value.toString())
            }
        }

        _binding.buttonPlay.setOnClickListener {
            try {
                val max = _binding.edittextMaxNumber.text.toString().toInt()
                val turns = _binding.edittextTurnsNumber.text.toString().toInt()

                val action = SettingsFragmentDirections.actionSettingsFragmentToSecretNumberFragment(max,turns)
                findNavController().navigate(action)
            } catch (e: NumberFormatException) {
                Toast
                        .makeText(this.context, getString(R.string.toast_choose_number), Toast.LENGTH_LONG)
                        .show()
            }
        }

        _binding.buttonSave.setOnClickListener {
            try {
                val max = _binding.edittextMaxNumber.text.toString().toInt()
                val turns = _binding.edittextTurnsNumber.text.toString().toInt()

                settingsModel.save(max, turns)
            } catch (e: NumberFormatException) {
                Toast
                    .makeText(this.context, getString(R.string.toast_choose_number), Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}