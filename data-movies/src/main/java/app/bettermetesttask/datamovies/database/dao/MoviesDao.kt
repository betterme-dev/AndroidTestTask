package app.bettermetesttask.datamovies.database.dao

import androidx.room.*
import app.bettermetesttask.datamovies.database.entities.MovieEntity

@Dao
interface MoviesDao{

    @Insert
    fun insertMovie(movie: MovieEntity)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("DELETE FROM MoviesTable")
    fun deleteMovies()

}