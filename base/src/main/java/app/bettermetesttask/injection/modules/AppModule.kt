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
            timberInitializer: TimberInitializer,
            appDispatchersInitializer: DispatchersInitializer,
            appLifecycleObserversInitializer: AppLifecycleObserversInitializer
        ) = AppInitializers(
            timberInitializer, appDispatchersInitializer, appLifecycleObserversInitializer
        )

        @Provides
        fun provideResources(context: Context): Resources = context.resources

    }
}