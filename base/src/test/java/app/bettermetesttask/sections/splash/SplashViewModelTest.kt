package app.bettermetesttask.sections.splash

import app.bettermetesttask.navigation.HomeCoordinator
import app.bettermetesttask.tests.androidcommon.InstantTaskExecutorExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(InstantTaskExecutorExtension::class, MockitoExtension::class)
internal class SplashViewModelTest {

    private val coordinator: HomeCoordinator = mock()

    private val viewModel = SplashViewModel(coordinator)

    @Test
    fun `handle app launch`() {
        viewModel.handleAppLaunch()

        verify(coordinator).start()
        verifyNoMoreInteractions(coordinator)
    }
}