package app.bettermetesttask.datamovies.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.bettermetesttask.datamovies.database.dao.MoviesDao
import app.bettermetesttask.datamovies.database.entities.MovieEntity

const val DB_NAME = "movies_database.db"

@Database(version = 1, entities = [MovieEntity::class])
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun getMoviesDao(): MoviesDao

}