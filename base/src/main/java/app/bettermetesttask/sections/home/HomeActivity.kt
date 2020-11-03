package app.bettermetesttask.sections.home

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import app.bettermetesttask.R
import app.bettermetesttask.featurecommon.base.OnBackPressedHandler
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class HomeActivity : AppCompatActivity(R.layout.activity_main), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private val navListener: NavController.OnDestinationChangedListener = initNavListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNavigationFragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(navListener)
    }

    override fun onDestroy() {
        navController.removeOnDestinationChangedListener(navListener)
        super.onDestroy()
    }

    override fun onBackPressed() {
        val currentFragment = navHostFragment.childFragmentManager.primaryNavigationFragment
        if (currentFragment is OnBackPressedHandler) {
            currentFragment.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    @Suppress("unused")
    private fun colorStatusBar(@IdRes fragmentId: Int) {
        window.statusBarColor = when (fragmentId) {
            R.id.moviesFragment -> {
                ResourcesCompat.getColor(resources, R.color.white, theme)
            }
            else -> {
                ResourcesCompat.getColor(resources, R.color.main_black, theme)
            }
        }
    }

    private fun initNavListener(): NavController.OnDestinationChangedListener {
        return NavController.OnDestinationChangedListener { _, destination, _ ->

            //as soon as any fragment except for splash shows up we can safely change window background
            // checking for LayerDrawable to avoid redundant background changes
            if (destination.id != R.id.fragmentSplash
                && window.decorView.background is LayerDrawable
            ) {
                window.setBackgroundDrawableResource(R.color.main_black)
            }
        }
    }

}