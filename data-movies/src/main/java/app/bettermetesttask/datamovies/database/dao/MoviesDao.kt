package app.bettermetesttask.datamovies.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import app.bettermetesttask.datamovies.database.entities.MovieEntity

@Dao
interface MoviesDao{

    @Query("SELECT * FROM MoviesTable")
    suspend fun selectMovies(): List<MovieEntity>

    @Query("SELECT * FROM MoviesTable WHERE id = :id")
    suspend fun selectMovieById(id: Int): List<MovieEntity>

    @Insert
    suspend fun insertMovie(movie: MovieEntity)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("DELETE FROM MoviesTable")
    fun deleteMovies()

}