package app.bettermetesttask.injection.components

import android.app.Application
import android.content.Context
import app.bettermetesttask.AndroidTestTaskApp
import app.bettermetesttask.datamovies.injection.MoviesDataModule
import app.bettermetesttask.featurecommon.injection.modules.CommonModule
import app.bettermetesttask.injection.modules.AppModule
import app.bettermetesttask.injection.modules.HomeActivityModule
import app.bettermetesttask.networkcore.injection.NetworkCoreModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, AndroidSupportInjectionModule::class, HomeActivityModule::class,
        CommonModule::class, NetworkCoreModule::class, MoviesDataModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun appContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: AndroidTestTaskApp)
}