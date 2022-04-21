package app.bettermetesttask.domainmovies.entries

data class Movie (
    val id: Int,
    val title: String,
    val description: String,
    val posterPath: String?,
    val liked: Boolean = false
)