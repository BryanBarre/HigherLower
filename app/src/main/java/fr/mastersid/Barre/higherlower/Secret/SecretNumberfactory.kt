package fr.mastersid.Barre.higherlower.Secret

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

/**
 *Created by Bryan BARRE on 18/03/2021.
 */
class SecretNumberfactory(
    owner : SavedStateRegistryOwner ,
    private val turn : Int,
    private val max : Int

) : AbstractSavedStateViewModelFactory (owner , null ) {
    override fun <T : ViewModel ?> create (
        key : String ,
        modelClass : Class <T>,
        handle : SavedStateHandle
    ): T {
        if ( modelClass . isAssignableFrom ( SecretNumberModel :: class . java )) {
            @Suppress (" UNCHECKED_CAST ")
            return SecretNumberModel ( handle , turn,max ) as T
        }
        throw IllegalArgumentException (" Unknown ViewModel class ")
    }
}