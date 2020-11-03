package app.bettermetesttask.navigation

import javax.inject.Inject

interface HomeCoordinator {

    fun start()

}

class HomeCoordinatorImpl @Inject constructor(
    private val navigator: HomeNavigator
) : HomeCoordinator {

    override fun start() {
        navigator.navigateToMain()
    }
}