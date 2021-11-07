package fr.mastersid.martinez.higherlower

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SettingsModelFactory(private val context: Context?): ViewModelProvider.Factory {
    override  fun <T : ViewModel > create(modelClass: Class <T>): T {
        if (modelClass.isAssignableFrom(SettingsModel :: class.java)) {
            @Suppress("UNCHECKED_CAST")
            val backend = FavoriteSharedPreferencesBackEnd(context)
            val repository = FavoriteRepository(backend)
            return SettingsModel(repository) as T
        }
        throw IllegalArgumentException("Unknown  ViewModel  class")
    }
}