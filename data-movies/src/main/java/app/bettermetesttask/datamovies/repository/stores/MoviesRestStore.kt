package app.bettermetesttask.datamovies.repository.stores

import app.bettermetesttask.domainmovies.entries.Movie
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.random.Random

class MoviesRestStore @Inject constructor() {

    suspend fun getMovies(): List<Movie> {
        delay(Random.nextLong(500, 3_000))
        return MoviesFactory.createMoviesList()
    }
}