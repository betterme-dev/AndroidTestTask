package app.bettermetesttask.initializers

import android.app.Application
import app.bettermetesttask.domaincore.utils.coroutines.AppDispatchers
import app.bettermetesttask.domaincore.utils.coroutines.DispatcherProvider
import app.bettermetesttask.featurecommon.initializers.AppInitializer
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatchersInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        AppDispatchers.setInstance(object : DispatcherProvider {
            override fun main() = Dispatchers.Main
            override fun io() = Dispatchers.IO
            override fun default() = Dispatchers.Default
            override fun unconfined() = Dispatchers.Unconfined
        })
    }
}