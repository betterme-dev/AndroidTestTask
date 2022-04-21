package app.bettermetesttask.domainmovies.interactors

import app.bettermetesttask.domainmovies.repository.MoviesRepository
import javax.inject.Inject

class AddMovieToFavoritesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(id: Int) {
        repository.addMovieToFavorites(id)
    }
}