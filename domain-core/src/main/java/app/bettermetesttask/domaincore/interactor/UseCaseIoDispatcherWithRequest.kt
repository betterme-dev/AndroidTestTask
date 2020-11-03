package app.bettermetesttask.domaincore.interactor

import app.bettermetesttask.domaincore.utils.coroutines.AppDispatchers
import kotlinx.coroutines.withContext

abstract class UseCaseIoDispatcherWithRequest<Result, Request: Any> {

    protected lateinit var request: Request

    abstract suspend operator fun invoke(): Result

    suspend fun get(request: Request): Result = withContext(AppDispatchers.io()) {
        this@UseCaseIoDispatcherWithRequest.request = request
        invoke()
    }
}