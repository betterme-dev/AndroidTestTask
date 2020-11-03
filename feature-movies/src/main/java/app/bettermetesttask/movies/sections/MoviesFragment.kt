package app.bettermetesttask.movies.sections

import androidx.fragment.app.Fragment
import app.bettermetesttask.featurecommon.injection.utils.Injectable
import app.bettermetesttask.movies.R
import javax.inject.Inject
import javax.inject.Provider

class MoviesFragment : Fragment(R.layout.movies_fragment), Injectable {

    @Inject
    lateinit var viewModelProvider: Provider<MoviesViewModel>

}