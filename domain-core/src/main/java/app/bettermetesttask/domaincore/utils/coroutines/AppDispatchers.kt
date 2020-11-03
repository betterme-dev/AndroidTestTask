package app.bettermetesttask.domaincore.utils.coroutines

import kotlinx.coroutines.CoroutineDispatcher

@Suppress("unused")
object AppDispatchers {

    private lateinit var instance: DispatcherProvider

    fun setInstance(instance: DispatcherProvider) {
        AppDispatchers.instance = instance
    }

    fun main(): CoroutineDispatcher = instance.main()

    fun io(): CoroutineDispatcher = instance.io()

    fun default(): CoroutineDispatcher = instance.default()

    fun unconfined(): CoroutineDispatcher = instance.unconfined()

}