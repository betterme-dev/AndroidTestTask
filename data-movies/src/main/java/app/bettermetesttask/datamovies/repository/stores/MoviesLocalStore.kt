package app.bettermetesttask.datamovies.repository.stores

import app.bettermetesttask.datamovies.database.MoviesDatabase
import app.bettermetesttask.datamovies.database.entities.MovieEntity
import javax.inject.Inject

interface MoviesLocalStore {

    fun getMovies(): List<MovieEntity>

    fun getMovie(id: Int): MovieEntity

}

class MoviesLocalStoreImpl @Inject constructor(
    private val database: MoviesDatabase
) : MoviesLocalStore {

    override fun getMovies(): List<MovieEntity> {
        TODO("Not yet implemented")
    }

    override fun getMovie(id: Int): MovieEntity {
        TODO("Not yet implemented")
    }

}