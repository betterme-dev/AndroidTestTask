package app.bettermetesttask.datamovies.repository

import app.bettermetesttask.datamovies.repository.stores.MoviesLocalStore
import app.bettermetesttask.domainmovies.entries.Movie
import app.bettermetesttask.domainmovies.repoistory.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val localStore: MoviesLocalStore
): MoviesRepository {

    override fun getMovies(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getMovie(id: Int): Movie {
        TODO("Not yet implemented")
    }

}