package app.bettermetesttask.stream.sections

import app.bettermetesttask.movies.sections.MoviesViewModel
import app.bettermetesttask.tests.androidcommon.InstantTaskExecutorExtension
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(InstantTaskExecutorExtension::class, MockitoExtension::class)
internal class MoviesViewModelTest {

    private val viewModel = MoviesViewModel()


}