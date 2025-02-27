package app.bettermetesttask.navigation

import androidx.navigation.NavController
import app.bettermetesttask.R
import app.bettermetesttask.constants.TaskConstants
import app.bettermetesttask.constants.TaskVariance
import app.bettermetesttask.featurecommon.utils.navigation.executeSafeNavAction
import dagger.Lazy
import javax.inject.Inject

interface HomeNavigator {
    fun navigateToMain()
}

class HomeNavigatorImpl @Inject constructor(
    private val navController: Lazy<NavController>,
) : HomeNavigator {

    override fun navigateToMain() {
        executeSafeNavAction {
            when (TaskConstants.TASK_VARIANCE) {
                TaskVariance.COMPOSE -> {
                    navController.get().navigate(R.id.action_show_compose_movies)
                }

                TaskVariance.XML -> {
                    navController.get().navigate(R.id.action_show_movies)
                }
            }
        }
    }
}