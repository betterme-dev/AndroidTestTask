package app.bettermetesttask.sections.splash

import app.bettermetesttask.domaincore.utils.preferences.Preferences
import app.bettermetesttask.navigation.HomeCoordinator
import app.bettermetesttask.tests.androidcommon.InstantTaskExecutorExtension
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(InstantTaskExecutorExtension::class, MockitoExtension::class)
internal class SplashViewModelTest {

    private val preferences: Preferences = mock()
    private val coordinator: HomeCoordinator = mock()

    private val viewModel = SplashViewModel(preferences, coordinator)

    @Test
    fun `handle app launch`() {
        viewModel.handleAppLaunch()

        verify(coordinator).start(false)
        verifyNoMoreInteractions(coordinator)
        verifyZeroInteractions(preferences)
    }
}