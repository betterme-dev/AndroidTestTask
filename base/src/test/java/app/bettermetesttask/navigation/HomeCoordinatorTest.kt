package app.bettermetesttask.navigation

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class HomeCoordinatorTest {

    private val navigator: HomeNavigator = mock()

    private val coordinator: HomeCoordinator = HomeCoordinatorImpl(navigator)

    @ParameterizedTest(name = "handle start when first launch is: {0}")
    @ValueSource(booleans = [true, false])
    fun `handle start when first launch`(isFirstLaunch: Boolean) {
        coordinator.start(isFirstLaunch)

        if (isFirstLaunch) {
            verify(navigator).navigateToOnboarding()
        } else {
            verify(navigator).navigateToMain()
        }
        verifyNoMoreInteractions(navigator)
    }
}