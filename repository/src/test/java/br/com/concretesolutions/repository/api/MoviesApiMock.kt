package br.com.concretesolutions.repository.api

import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import retrofit2.converter.gson.GsonConverterFactory

object MoviesApiMock {

    fun mock(server: RequestMatcherRule) {
        val rootUrl: String = server.url("/").toString()
        val moviesApi = ApiBuilder<MediaService>()
                .baseUrl(rootUrl)
                .converterFactory(GsonConverterFactory.create())
                .okHttpClient(MediaApi.okHttpClient())
                .service(MediaService::class.java)
                .build()
        MediaApi.INSTANCE = moviesApi
    }

    fun reset() {
        MediaApi.INSTANCE = null
    }
}


