package app.bettermetesttask.featurecommon.utils.lazy

/**
 * Creates not synchronized lazy block - useful if you need to inject instances in UI thread.
 */
fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)