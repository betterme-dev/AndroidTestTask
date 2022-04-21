package app.bettermetesttask.domaincore.utils

sealed class Result<out T> {

    companion object {
        inline fun <T> of(block: () -> T): Result<T> {
            return runCatching { block() }
                .fold({
                    Success(it)
                }, {
                    Error(it)
                })
        }
    }

    data class Success<out T>(val data: T) : Result<T>()

    data class Error(val error: Throwable) : Result<Nothing>()

    override fun toString(): String =
        when (this) {
            is Success<*> -> "Success[data= $data]"
            is Error -> "Error[throwable= $error]"
        }
}