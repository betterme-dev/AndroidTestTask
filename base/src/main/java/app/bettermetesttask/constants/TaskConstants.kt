package app.bettermetesttask.constants

enum class TaskVariance {
    COMPOSE,
    XML,
}

/**
 * The task variation - XML means that MoviesFragment is used as an entry point,
 * while COMPOSE means that MoviesComposeFragment is used instead.
 */
object TaskConstants {
    val TASK_VARIANCE = TaskVariance.COMPOSE
}