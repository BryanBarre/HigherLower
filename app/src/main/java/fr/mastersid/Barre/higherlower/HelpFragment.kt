package fr.mastersid.Barre.higherlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.mastersid.Barre.higherlower.databinding.FragmentHelpBinding

/**
 *Created by Bryan BARRE on 29/03/2021.
 */
class HelpFragment : Fragment() {
    override fun onCreateView (
        inflater:LayoutInflater,
        container:ViewGroup?,
        savedInstanceState:Bundle?
    ): View? {
        val binding = FragmentHelpBinding.inflate(inflater)
        return binding.root
    }
}