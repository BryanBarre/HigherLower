package fr.mastersid.Barre.higherlower

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import fr.mastersid.Barre.higherlower.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity () {
    override fun onCreate (savedInstanceState:Bundle?) {
        super.onCreate (savedInstanceState)//savestate handle
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView (binding.root)

        setSupportActionBar(binding.toolbar)
        val navController = findNavController (R.id.nav_host_fragment )
        val appBarConfiguration = AppBarConfiguration ( navController . graph )
        binding . toolbar . setupWithNavController ( navController , appBarConfiguration )
    }
    override fun onCreateOptionsMenu ( menu : Menu?): Boolean {
        menuInflater . inflate (R. menu . toolbar_menu , menu )
        return true
    }
    override fun onOptionsItemSelected ( item : MenuItem): Boolean {
        return item . onNavDestinationSelected ( findNavController (R.id.nav_host_fragment))
    }
}
