package app.bettermetesttask.datamovies.injection

import android.content.Context
import androidx.room.Room
import app.bettermetesttask.datamovies.database.DB_NAME
import app.bettermetesttask.datamovies.database.MoviesDatabase
import app.bettermetesttask.datamovies.repository.MoviesRepositoryImpl
import app.bettermetesttask.datamovies.repository.stores.MoviesLocalStore
import app.bettermetesttask.datamovies.repository.stores.MoviesLocalStoreImpl
import app.bettermetesttask.domainmovies.repoistory.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesDataModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): MoviesDatabase {
        return Room.databaseBuilder(context.applicationContext, MoviesDatabase::class.java, DB_NAME)
            .build()
    }

    @Provides
    fun provideLocalStore(database: MoviesDatabase): MoviesLocalStore = MoviesLocalStoreImpl(database)

    @Provides
    @Singleton
    fun provideMoviesRepository(localStore: MoviesLocalStore): MoviesRepository {
        return MoviesRepositoryImpl(localStore)
    }

}