package br.com.concretesolutions.repository.api

import okhttp3.mockwebserver.MockWebServer
import retrofit2.converter.gson.GsonConverterFactory

object MoviesApiMock {

    fun mock(server: MockWebServer) {
        val rootUrl: String = server.url("/").toString()
        val moviesApi = ApiBuilder<MoviesService>()
                .baseUrl(rootUrl)
                .converterFactory(GsonConverterFactory.create())
                .okHttpClient(MoviesApi.okHttpClient())
                .service(MoviesService::class.java)
                .build()
        MoviesApi.INSTANCE = moviesApi
    }
}


