package app.bettermetesttask.domaincore.utils.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    fun main(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun default(): CoroutineDispatcher

    fun unconfined(): CoroutineDispatcher
}