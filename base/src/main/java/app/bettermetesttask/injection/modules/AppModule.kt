package app.bettermetesttask.injection.modules

import android.content.Context
import android.content.res.Resources
import app.bettermetesttask.featurecommon.initializers.AppInitializers
import app.bettermetesttask.initializers.*
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {

    companion object {

        @Provides
        fun provideAppInitializers(
            stethoInitializer: StethoInitializer,
            timberInitializer: TimberInitializer,
            appSchedulersInitializer: AppSchedulersInitializer,
            appLifecycleObserversInitializer: AppLifecycleObserversInitializer
        ) = AppInitializers(
            stethoInitializer, timberInitializer, appSchedulersInitializer, appLifecycleObserversInitializer
        )

        @Provides
        fun provideResources(context: Context): Resources = context.resources

    }
}