package app.bettermetesttask.injection.modules

import androidx.navigation.NavController
import androidx.navigation.Navigation
import app.bettermetesttask.R
import app.bettermetesttask.featurecommon.injection.scopes.ActivityScope
import app.bettermetesttask.navigation.HomeCoordinator
import app.bettermetesttask.navigation.HomeCoordinatorImpl
import app.bettermetesttask.navigation.HomeNavigator
import app.bettermetesttask.navigation.HomeNavigatorImpl
import app.bettermetesttask.sections.home.HomeActivity
import dagger.Module
import dagger.Provides

@Module
class MainNavigationModule {

    @Provides
    @ActivityScope
    fun provideNavController(activity: HomeActivity): NavController =
        Navigation.findNavController(activity, R.id.mainNavigationFragment)

    @Provides
    fun bindNavigator(navigatorImpl: HomeNavigatorImpl): HomeNavigator {
        return navigatorImpl
    }

    @Provides
    fun bindCoordinator(coordinatorImpl: HomeCoordinatorImpl): HomeCoordinator {
        return coordinatorImpl
    }
}