package app.bettermetesttask.movies.sections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import app.bettermetesttask.featurecommon.injection.utils.Injectable
import app.bettermetesttask.featurecommon.injection.viewmodel.SimpleViewModelProviderFactory
import app.bettermetesttask.featurecommon.utils.views.gone
import app.bettermetesttask.featurecommon.utils.views.visible
import app.bettermetesttask.movies.R
import app.bettermetesttask.movies.databinding.MoviesFragmentBinding
import kotlinx.android.synthetic.main.movies_fragment.progressBar
import kotlinx.android.synthetic.main.movies_fragment.rvList
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import javax.inject.Inject
import javax.inject.Provider

class MoviesFragment : Fragment(R.layout.movies_fragment), Injectable {

    @Inject
    lateinit var viewModelProvider: Provider<MoviesViewModel>

    @Inject
    lateinit var adapter: MoviesAdapter

    private lateinit var binding: MoviesFragmentBinding

    private val viewModel by viewModels<MoviesViewModel> { SimpleViewModelProviderFactory(viewModelProvider) }

    private var job: Job? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MoviesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.onItemClicked = { movie ->
            viewModel.openMovieDetails(movie)
        }

        adapter.onItemLiked = { movie ->
            viewModel.likeMovie(movie)
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadMovies()

        job = lifecycleScope.launchWhenCreated {
            viewModel.moviesStateFlow.collect(::renderMoviesState)
        }
    }

    override fun onDestroyView() {
        job?.cancel()
        super.onDestroyView()
    }

    private fun renderMoviesState(state: MoviesState) {
        when (state) {
            MoviesState.Loading -> {
                rvList.gone()
                progressBar.visible()
            }
            is MoviesState.Loaded -> {
                progressBar.gone()
                rvList.visible()
            }
            else -> {
                // no op
                progressBar.gone()
                rvList.gone()
            }
        }
    }
}