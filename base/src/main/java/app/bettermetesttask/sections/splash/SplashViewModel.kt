package app.bettermetesttask.sections.splash

import androidx.lifecycle.ViewModel
import app.bettermetesttask.navigation.HomeCoordinator
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val coordinator: HomeCoordinator
) : ViewModel() {

    fun handleAppLaunch() {
        coordinator.start()
    }
}