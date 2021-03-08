package fr.mastersid.Barre.higherlower

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import fr.mastersid.Barre.higherlower.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity () {
    override fun onCreate (savedInstanceState:Bundle?) {
        super.onCreate (savedInstanceState)//savestate handle
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView (binding.root)
    }
}
