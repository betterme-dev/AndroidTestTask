package app.bettermetesttask.networkcore

import okhttp3.Call
import okhttp3.Request
import retrofit2.Retrofit

@Suppress("unused")
@PublishedApi
internal inline fun Retrofit.Builder.callFactory(
    crossinline body: (Request) -> Call
) = callFactory { request -> body(request) }