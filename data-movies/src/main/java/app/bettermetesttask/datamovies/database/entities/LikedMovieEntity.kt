package app.bettermetesttask.datamovies.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LikedMovieEntry")
data class LikedMovieEntity(
    @PrimaryKey @ColumnInfo(name = "movie_id")
    val movieId: Int
)