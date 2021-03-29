package fr.mastersid.Barre.higherlower

import android.content.Context
import android.util.Log

/**
 *Created by Bryan BARRE on 22/03/2021.
 */
class FavoriteSharedPreferencesBackEnd ( context : Context ?): FavoriteBackEnd {
    private val sharedPreferences = context ?. getSharedPreferences ( FILE_NAME ,
            Context . MODE_PRIVATE )
    override suspend fun saveFavorite (turn: Int, max: Int) {
        Log .d(" Favorite ", " saving ... ")
        sharedPreferences ?. edit () ?. apply {
            putInt (FAVORITE_VALUE1 , turn)
            putInt (FAVORITE_VALUE2 , max)
            System.out.println("(((((((((((((((((((((((((((((((((("+FAVORITE_VALUE1+"(((("+turn)
            System.out.println("(((((((((((((((((((((((((((((((((("+FAVORITE_VALUE2+"(((("+max)
            apply ()
        }
        Log .d(" Favorite ", " saved ")
    }

    override suspend fun loadFavoriteTurn (): Int {
        Log.d("Favorite", "loading... ")
        val turns = sharedPreferences ?.getInt(FAVORITE_VALUE1,FavoriteBackEnd.NO_VALUE1)?:FavoriteBackEnd.NO_VALUE1
        System.out.println("---------------***************turn= "+turns)
        Log .d(" Favorite ", " loaded ")
        return turns
    }
    override suspend fun loadFavoriteMax (): Int {
        Log.d("Favorite", "loading... ")
        val max = sharedPreferences?.getInt(FAVORITE_VALUE2,FavoriteBackEnd.NO_VALUE2)?:FavoriteBackEnd.NO_VALUE2
        System.out.println("---------------***************max= "+max)
        Log .d(" Favorite ", " loaded ")
        return max
    }


    companion object {
        private const val FILE_NAME = " favorite_shared_preferences_file "
        private const val FAVORITE_VALUE1 = " favorite_value1 "
        private const val FAVORITE_VALUE2 = " favorite_value2 "

    }
}
