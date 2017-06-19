package br.com.concretesolutions.repository.api

import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import retrofit2.converter.gson.GsonConverterFactory

object MoviesApiMock {

    fun mock(server: RequestMatcherRule) {
        val rootUrl: String = server.url("/").toString()
        val moviesApi = ApiBuilder<MoviesService>()
                .baseUrl(rootUrl)
                .converterFactory(GsonConverterFactory.create())
                .okHttpClient(MoviesApi.okHttpClient())
                .service(MoviesService::class.java)
                .build()
        MoviesApi.INSTANCE = moviesApi
    }

    fun reset() {
        MoviesApi.INSTANCE = null
    }
}


