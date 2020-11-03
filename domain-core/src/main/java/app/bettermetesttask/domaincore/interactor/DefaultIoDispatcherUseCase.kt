package app.bettermetesttask.domaincore.interactor

import app.bettermetesttask.domaincore.utils.coroutines.AppDispatchers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class DefaultIoDispatcherUseCase<Result> {

    abstract suspend operator fun invoke(): Result

    suspend fun get(): Result = withContext(AppDispatchers.io()) {
        invoke()
    }
}