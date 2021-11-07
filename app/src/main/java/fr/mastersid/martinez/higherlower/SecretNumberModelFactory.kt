package fr.mastersid.martinez.higherlower

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class SecretNumberModelFactory(
    owner: SavedStateRegistryOwner,
    private val max: Int,
    private val turns: Int
    ) : AbstractSavedStateViewModelFactory(owner, null) {


    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(SecretNumberModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SecretNumberModel(handle, max, turns) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
