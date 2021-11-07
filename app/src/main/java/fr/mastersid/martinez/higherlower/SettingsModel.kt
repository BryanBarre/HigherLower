package fr.mastersid.martinez.higherlower

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsModel(private val repository: FavoriteRepository): ViewModel() {

    private val _maxFavorite = MutableLiveData(NO_VALUE)
    val maxFavorite: LiveData<Int>
        get() = _maxFavorite

    private val _turnsFavorite = MutableLiveData(NO_VALUE)
    val turnsFavorite: LiveData<Int>
        get() = _turnsFavorite

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _maxFavorite.postValue(repository.loadMaxFavorite())
            _turnsFavorite.postValue(repository.loadTurnsFavorite())
        }
    }

    fun save(max: Int, turns: Int) {
        Log.d("Favorite", "save max=$max, turns = $turns")
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveFavorites(max, turns)
        }
        Log.d("Favorite", "end of dummy save")
    }

    companion object {
        const val NO_VALUE = FavoriteRepository.NO_VALUE
    }
}