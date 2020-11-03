package app.bettermetesttask.featurecommon.initializers

import android.app.Application

/**
 * This class dispatches all app initializers relevant for this app.
 *
 * @param appInitializers list of app initializers for all frameworks / application-scoped
 *      observers.
 */
class AppInitializers(private vararg val appInitializers: AppInitializer) : AppInitializer {

    override fun init(application: Application) {
        appInitializers.forEach {
            it.init(application)
        }
    }
}
