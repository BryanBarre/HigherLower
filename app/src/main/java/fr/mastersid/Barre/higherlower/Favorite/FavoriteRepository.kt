package fr.mastersid.Barre.higherlower.Favorite

/**
 *Created by Bryan BARRE on 22/03/2021.
 */
class FavoriteRepository(private val favoriteBackEnd: FavoriteBackEnd) {
suspend fun saveFavorite(turn: Int, max: Int){
    favoriteBackEnd.saveFavorite(turn,max)
}
    suspend fun loadFavoriteTurn (): Int {
        return favoriteBackEnd.loadFavoriteTurn()
    }

    suspend fun loadFavoriteMax (): Int {
        return favoriteBackEnd.loadFavoriteMax()
    }
    companion object {
        const val NO_VALUE1 = FavoriteBackEnd.NO_VALUE1
        const val NO_VALUE2 = FavoriteBackEnd.NO_VALUE2

    }
}