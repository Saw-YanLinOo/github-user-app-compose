package com.agb.github_user_app.data.network.uitls

import com.agb.github_user_app.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

fun String.prefixBearer() = "Bearer $this"

fun tokenInterceptor(
    chain: Interceptor.Chain
): Response {
    val accessToken = BuildConfig.API_TOKEN
    val originalRequest = chain.request()
    val request = originalRequest.newBuilder()
        .addHeader("Content-Type", "application/json-patch+json")
        .addHeader("Authorization", accessToken.prefixBearer())
        .build()
    return chain.proceed(request = request)
}