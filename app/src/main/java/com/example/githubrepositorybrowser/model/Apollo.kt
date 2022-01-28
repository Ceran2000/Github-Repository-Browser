package com.example.githubrepositorybrowser.model


import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

private class AuthorizationInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer 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")
            .build()

        return chain.proceed(request)
    }
}

class GitHubApi{

}

private var instance: ApolloClient? = null

fun getApolloClient(): ApolloClient {
    if (instance != null){
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