package app.bettermetesttask.networkcore.injection

import android.content.Context
import app.bettermetesttask.networkcore.BuildConfig
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkCoreModule {

    private const val CACHE_SIZE = 10L * 1024L * 1024L
    private const val CACHE_DIR_NAME = "MoviesResponseCache"

    private const val CLIENT_CONNECT_TIMEOUT_SECONDS = 30L
    private const val CLIENT_READ_TIMEOUT_SECONDS = 30L
    private const val CLIENT_WRITE_TIMEOUT_SECONDS = 10L

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache {
        return Cache(File(context.cacheDir, CACHE_DIR_NAME), CACHE_SIZE)
    }

    @Provides
    @Singleton
    fun provideStethoInterceptor() = StethoInterceptor()

    @Provides
    @Singleton
    fun provideChuckerInterceptor(context: Context) = ChuckerInterceptor(context)

    @Provides
    @Singleton
    fun provideOkHttpInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        stethoInterceptor: StethoInterceptor,
        chuckInterceptor: ChuckerInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {

        val clientBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            clientBuilder
                .addNetworkInterceptor(stethoInterceptor)
                .addNetworkInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(chuckInterceptor)
        }
        clientBuilder
            .cache(cache)
            .readTimeout(CLIENT_READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(CLIENT_WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CLIENT_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)

        return clientBuilder.build()
    }
}