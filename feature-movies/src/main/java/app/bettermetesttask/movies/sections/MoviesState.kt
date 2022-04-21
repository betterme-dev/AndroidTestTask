package app.bettermetesttask.movies.sections

import app.bettermetesttask.domainmovies.entries.Movie

sealed class MoviesState {

    object Initial : MoviesState()

    object Loading : MoviesState()

    data class Loaded(val movies: List<Movie>) : MoviesState()
}