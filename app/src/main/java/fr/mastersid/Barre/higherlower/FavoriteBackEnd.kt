package fr.mastersid.Barre.higherlower

/**
 *Created by Bryan BARRE on 22/03/2021.
 */
interface FavoriteBackEnd {
    suspend fun saveFavorite (turn: Int, max: Int)

    suspend fun loadFavoriteTurn (): Int
    suspend fun loadFavoriteMax (): Int

    companion object {
        const val NO_VALUE1 = -1
        const val NO_VALUE2=-1
    }
}