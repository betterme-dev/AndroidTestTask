package app.bettermetesttask.initializers

import android.app.Application
import app.bettermetesttask.BuildConfig
import app.bettermetesttask.featurecommon.initializers.AppInitializer
import com.facebook.stetho.Stetho
import javax.inject.Inject

class StethoInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(application)
        }
    }
}