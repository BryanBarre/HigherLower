package fr.mastersid.Barre.higherlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import fr.mastersid.Barre.higherlower.databinding.FragmentSecretnumberBinding
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
        _binding.idPlay.setOnClickListener {
            val turns = _binding.idTurns.text.toString().toInt()
            val max = _binding.idSecretNumbeMaxValue.text.toString().toInt()
            val action = SettingsFragmentDirections.actionSettingsFragmentToSecretNumberFragment(turns,max)
            findNavController().navigate(action)
        }
     }
}

