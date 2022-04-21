package app.bettermetesttask.domainmovies.interactors

import app.bettermetesttask.domaincore.utils.Result
import app.bettermetesttask.domainmovies.entries.Movie
import app.bettermetesttask.domainmovies.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(): Flow<Result<List<Movie>>> {
        return when (val result = repository.getMovies()) {
            is Result.Success -> {
                repository.observeLikedMovieIds()
                    .map { likedMoviesIds ->
                        val movies = result.data.map {
                            if (likedMoviesIds.contains(it.id)) {
                                it.copy(liked = true)
                            } else {
                                it
                            }
                        }
                        Result.Success(movies)
                    }
            }
            is Result.Error -> {
                flowOf(result)
            }
        }
    }
}