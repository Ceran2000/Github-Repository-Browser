package com.example.githubrepositorybrowser.model


import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.example.githubrepositorybrowser.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

private var instance: ApolloClient? = null

fun getApolloClient(): ApolloClient {
    if (instance != null) {
        return instance!!
    }
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthorizationInterceptor())
        .build()

    instance = ApolloClient.Builder()
        .serverUrl("https://api.github.com/graphql")
        .okHttpClient(okHttpClient)
        .build()

    return instance!!
}

private class AuthorizationInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", BuildConfig.PersonalAccessToken)
            .build()

        return chain.proceed(request)
    }
}



