package fr.mastersid.martinez.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import fr.mastersid.martinez.higherlower.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = if (binding.drawerLayout != null) {
            AppBarConfiguration(navController.graph, binding.drawerLayout)
        } else {
            AppBarConfiguration(navController.graph)
        }

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)


        binding.navView.setNavigationItemSelectedListener { item ->
            binding.drawerLayout?.closeDrawers()
            if (item.itemId == R.id.secretNumberFragment_100) {
                val action = NavGraphDirections.actionGlobalSecretNumberFragment(100,6)
                findNavController(R.id.navHostFragment).navigate(action)
                true
            } else {
                item.onNavDestinationSelected(findNavController(R.id.navHostFragment))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.navHostFragment))
    }
}