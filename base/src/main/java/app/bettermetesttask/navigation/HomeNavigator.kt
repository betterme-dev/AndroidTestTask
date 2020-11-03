package app.bettermetesttask.navigation

import androidx.navigation.NavController
import app.bettermetesttask.R
import app.bettermetesttask.featurecommon.utils.navigation.executeSafeNavAction
import dagger.Lazy
import javax.inject.Inject

interface HomeNavigator {

    fun navigateToMain()

}

class HomeNavigatorImpl @Inject constructor(
    private val navController: Lazy<NavController>
) : HomeNavigator {

    override fun navigateToMain() {
        executeSafeNavAction {
            navController.get().navigate(R.id.action_show_movies)
        }
    }
}