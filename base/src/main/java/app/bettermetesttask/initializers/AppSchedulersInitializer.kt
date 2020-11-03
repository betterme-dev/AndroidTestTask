package app.bettermetesttask.initializers

import android.app.Application
import app.bettermetesttask.domaincore.utils.rx.AppSchedulers
import app.bettermetesttask.featurecommon.initializers.AppInitializer
import app.bettermetesttask.featurecommon.utils.rx.DefaultSchedulerProvider
import javax.inject.Inject

class AppSchedulersInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        AppSchedulers.setInstance(DefaultSchedulerProvider())
    }
}