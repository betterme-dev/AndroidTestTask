package app.bettermetesttask.testscommon

import app.bettermetesttask.domaincore.utils.coroutines.AppDispatchers
import app.bettermetesttask.domaincore.utils.coroutines.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

@ExperimentalCoroutinesApi
class CoroutinesExtension(
    private val dispatcher: CoroutineDispatcher = StandardTestDispatcher()
) : BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) {
        Dispatchers.setMain(dispatcher)
        AppDispatchers.setInstance(object : DispatcherProvider {

            override fun main(): CoroutineDispatcher = dispatcher

            override fun io(): CoroutineDispatcher = dispatcher

            override fun default(): CoroutineDispatcher = dispatcher

            override fun unconfined(): CoroutineDispatcher = dispatcher
        })
    }

    override fun afterEach(context: ExtensionContext?) {
        Dispatchers.resetMain()
    }
}