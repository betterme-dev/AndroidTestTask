package app.bettermetesttask.datamovies.repository.stores

import app.bettermetesttask.domainmovies.entries.Movie

object MoviesFactory {
    private val moviePosterUrls = listOf(
        "https://www.themoviedb.org/t/p/w440_and_h660_face/x6FsYvt33846IQnDSFxla9j0RX8.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/nJUHX3XL1jMkk8honUZnUmudFb9.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/lWlsZIsrGVWHtBeoOeLxIKDd9uy.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/oj4XM6wpGRIcx3QoQx1PF1fx5E5.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/5yhgm5JSMHOT2AWlZXeb8aY0qs9.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/c4ig0VYwCAnyULaoY4r45ki29h0.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/g18jnJuhIujMYErHqeG5t8U5F9X.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/sz4zF5z9zyFh8Z6g5IQPNq91cI7.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/kVr5zIAFSPRQ57Y1zE7KzmhzdMQ.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/wRnbWt44nKjsFPrqSmwYki5vZtF.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/icx3Cu6ktIXgr5o2WOeekEFRCdM.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/wRnbWt44nKjsFPrqSmwYki5vZtF.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/velWPhVMQeQKcxggNEU8YmIo52R.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/fIE3lAGcZDV1G6XM5KmuWnNsPp1.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/3jcbDmRFiQ83drXNOvRDeKHxS0C.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/9zM8ECgHL0fz5AJzm5mDamLHwEB.jpg",
        "https://www.themoviedb.org/t/p/w440_and_h660_face/oPxnRhyAIzJKGUEdSiwTJQBa3NM.jpg"
    )

    fun createMoviesList(): List<Movie> {
        return moviePosterUrls.mapIndexed { index, posterUrl ->
            Movie(
                id = index,
                title = "Movie #$index",
                description = "Some movie description #$index",
                posterPath = posterUrl
            )
        }
    }
}