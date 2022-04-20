package app.bettermetesttask.datamovies.repository.stores

import app.bettermetesttask.datamovies.database.MoviesDatabase
import app.bettermetesttask.datamovies.database.dao.MoviesDao
import app.bettermetesttask.datamovies.database.entities.MovieEntity
import javax.inject.Inject

class MoviesLocalStore @Inject constructor(
    private val database: MoviesDatabase
) {

    private val moviesDao: MoviesDao
        get() = database.getMoviesDao()

    suspend fun getMovies(): List<MovieEntity> {
        return moviesDao.selectMovies()
    }

    suspend fun getMovie(id: Int): MovieEntity? {
        return moviesDao.selectMovieById(id).firstOrNull()
    }

}