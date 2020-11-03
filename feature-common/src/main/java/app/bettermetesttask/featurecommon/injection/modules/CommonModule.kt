package app.bettermetesttask.featurecommon.injection.modules

import app.bettermetesttask.domaincore.utils.connectivity.ConnectivityManager
import app.bettermetesttask.featurecommon.utils.connectivity.ConnectivityManagerImpl
import dagger.Binds
import dagger.Module

@Module(includes = [PreferencesModule::class])
abstract class CommonModule {

    @Binds
    abstract fun bindsConnectivityManager(connectivityManagerImpl: ConnectivityManagerImpl): ConnectivityManager

}