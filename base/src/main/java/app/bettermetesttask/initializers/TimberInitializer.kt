package app.bettermetesttask.initializers

import android.app.Application
import app.bettermetesttask.featurecommon.initializers.AppInitializer
import app.bettermetesttask.featurecommon.utils.build.isDevBuild
import app.bettermetesttask.featurecommon.utils.build.isReleaseBuild
import timber.log.Timber
import javax.inject.Inject

class TimberInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        when {
            isDevBuild -> Timber.plant(Timber.DebugTree())
            isReleaseBuild -> { }
        }
    }
}