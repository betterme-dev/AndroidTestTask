package app.bettermetesttask.domainmovies.repoistory

import app.bettermetesttask.domainmovies.entries.Movie

interface MoviesRepository {

    fun getMovies(): List<Movie>

    fun getMovie(id: Int): Movie

}