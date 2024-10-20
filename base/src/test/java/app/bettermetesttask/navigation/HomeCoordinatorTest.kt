package app.bettermetesttask.navigation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verifyNoMoreInteractions

@ExtendWith(MockitoExtension::class)
internal class HomeCoordinatorTest {

    private val navigator: HomeNavigator = mock()

    private val coordinator: HomeCoordinator = HomeCoordinatorImpl(navigator)

    @Test
    fun `handle start when first launch`() {
        coordinator.start()
        verify(navigator).navigateToMain()
        verifyNoMoreInteractions(navigator)
    }
}