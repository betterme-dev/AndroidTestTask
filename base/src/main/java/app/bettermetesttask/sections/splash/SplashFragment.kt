package app.bettermetesttask.sections.splash

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import app.bettermetesttask.R
import app.bettermetesttask.featurecommon.injection.utils.Injectable
import app.bettermetesttask.featurecommon.injection.viewmodel.SimpleViewModelProviderFactory
import app.bettermetesttask.featurecommon.injection.viewmodel.viewModel
import app.bettermetesttask.featurecommon.utils.lazy.unsafeLazy
import javax.inject.Inject
import javax.inject.Provider

class SplashFragment : Fragment(R.layout.splash_fragment), Injectable {

    @Inject
    lateinit var viewModelProvider: Provider<SplashViewModel>

    private val viewModel by unsafeLazy {
        viewModel<SplashViewModel>(SimpleViewModelProviderFactory(viewModelProvider))
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.handleAppLaunch()
        }, 2000L)
    }
}