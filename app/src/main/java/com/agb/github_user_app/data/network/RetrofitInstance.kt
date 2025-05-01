package com.agb.github_user_app.data.network

import com.agb.github_user_app.BuildConfig
import com.agb.github_user_app.BuildConfig.BASE_URL
import com.agb.github_user_app.data.network.uitls.tokenInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private  fun createOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .also {
                if (BuildConfig.DEBUG) {
                    it.addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }
            }
            .addInterceptor { chain ->
                tokenInterceptor(chain = chain)
            }
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()

    private  fun createRetrofit(): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true // 👈 this allows skipping unknown fields
            prettyPrint = true
            isLenient = true
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }


    val api = createRetrofit().create(GithubApi::class.java)

}