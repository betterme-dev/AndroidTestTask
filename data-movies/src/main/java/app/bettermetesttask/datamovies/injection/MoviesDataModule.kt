package app.bettermetesttask.datamovies.injection

import android.content.Context
import androidx.room.Room
import app.bettermetesttask.datamovies.database.DB_NAME
import app.bettermetesttask.datamovies.database.MoviesDatabase
import app.bettermetesttask.datamovies.repository.MoviesRepositoryImpl
import app.bettermetesttask.domainmovies.repoistory.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class MoviesDataModule {

    companion object {
        @Provides
        @Singleton
        fun provideDatabase(context: Context): MoviesDatabase {
            return Room.databaseBuilder(context.applicationContext, MoviesDatabase::class.java, DB_NAME)
                .build()
        }
    }

    @Binds
    abstract fun bindMoviesRepository(repositoryImpl: MoviesRepositoryImpl): MoviesRepository
}