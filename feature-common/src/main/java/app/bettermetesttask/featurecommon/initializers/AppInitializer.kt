package app.bettermetesttask.featurecommon.initializers

import android.app.Application

/**
 * Contract-interface which must be implemented by all initializer classes.
 *
 * Each initializer class can be considered as a class which encapsulates certain framework /
 * library or other application-scoped process initialization logic.
 */
interface AppInitializer {

    /**
     * The initialization of a certain framework or app-scoped observer should be performed in
     * this method implementation.
     */
    fun init(application: Application)
}