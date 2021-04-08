package fr.mastersid.Barre.higherlower.Settings

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.mastersid.Barre.higherlower.Favorite.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *Created by Bryan BARRE on 22/03/2021.
 */
class SettingsModel(private val repository: FavoriteRepository):ViewModel() {
    private val _favorite = MutableLiveData ( NO_VALUE1 )
    private val _favorite2 = MutableLiveData ( NO_VALUE2 )

    val favorite : LiveData<Int>
        get() = _favorite
    val favorite2 : LiveData<Int>
        get() = _favorite2
    init {
        viewModelScope.launch ( Dispatchers .IO) {
            _favorite.postValue (repository.loadFavoriteTurn())
            _favorite2.postValue (repository.loadFavoriteMax())


        }
    }
    fun save (turn: Int, max: Int){
        Log.d("Favorite","save turn=$turn")
        Log.d("Favorite","save max=$max")

        viewModelScope.launch (Dispatchers.IO) {
            repository.saveFavorite (turn,max)

        }
        Log.d("Favorite","end of save")
    }
    companion object {
        const val NO_VALUE1 = FavoriteRepository.NO_VALUE1
        const val NO_VALUE2 = FavoriteRepository.NO_VALUE2

    }
}