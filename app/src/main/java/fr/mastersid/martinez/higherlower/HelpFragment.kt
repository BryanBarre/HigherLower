package fr.mastersid.martinez.higherlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import fr.mastersid.martinez.higherlower.databinding.FragmentHelpBinding

class HelpFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHelpBinding.inflate(inflater)
        return binding.root
    }
}
