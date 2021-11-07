package fr.mastersid.martinez.higherlower

interface FavoriteBackEnd {
    suspend fun saveFavorites(favorite_max: Int, favorite_turns: Int)

    suspend fun loadMaxFavorite(): Int

    suspend fun loadTurnsFavorite(): Int

    companion object{
        const val NO_VALUE = -1
    }
}