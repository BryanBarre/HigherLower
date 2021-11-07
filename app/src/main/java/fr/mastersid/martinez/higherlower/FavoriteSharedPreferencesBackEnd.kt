package fr.mastersid.martinez.higherlower

import android.content.Context
import android.util.Log

class FavoriteSharedPreferencesBackEnd(context: Context?): FavoriteBackEnd {
    private val sharedPreferences = context?.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    override suspend fun saveFavorites(favorite_max: Int, favorite_turns: Int) {
        Log.d("Favorite", "saving...")
        sharedPreferences?.edit()?.apply() {
            putInt(FAVORITE_MAX_VALUE, favorite_max)
            putInt(FAVORITE_TURNS_VALUE, favorite_turns)
            commit()
        }
        Log.d("Favorite", "saved")
    }

    override suspend fun loadMaxFavorite(): Int {
        Log.d("Favorite", "loading max...")
        val favorite_max = sharedPreferences?.getInt(FAVORITE_MAX_VALUE, FavoriteBackEnd.NO_VALUE) ?: FavoriteBackEnd.NO_VALUE
        Log.d("Favorite", "loaded")

        return favorite_max
    }

    override suspend fun loadTurnsFavorite(): Int {
        Log.d("Favorite", "loading turns...")
        val favorite_turns = sharedPreferences?.getInt(FAVORITE_TURNS_VALUE, FavoriteBackEnd.NO_VALUE) ?: FavoriteBackEnd.NO_VALUE
        Log.d("Favorite", "loaded")

        return favorite_turns
    }

    companion object {
        private const val FILE_NAME = "favorite_shared_preference_file"

        private const val FAVORITE_MAX_VALUE = "favorite_max_value"
        private const val FAVORITE_TURNS_VALUE = "favorite_turns_value"
    }
}