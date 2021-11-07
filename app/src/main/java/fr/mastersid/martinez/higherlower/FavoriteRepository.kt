package fr.mastersid.martinez.higherlower

class FavoriteRepository(private val favoriteBackend: FavoriteBackEnd) {
    suspend fun saveFavorites(favorite_max: Int, favorite_turns: Int){
        favoriteBackend.saveFavorites(favorite_max, favorite_turns)
    }

    suspend fun loadMaxFavorite(): Int {
        return favoriteBackend.loadMaxFavorite()
    }

    suspend fun loadTurnsFavorite(): Int {
        return favoriteBackend.loadTurnsFavorite()
    }

    companion object{
        const val NO_VALUE = FavoriteBackEnd.NO_VALUE
    }
}