package br.com.concretesolutions.repository.api

object MoviesApiMock {

    fun instance(instance: MoviesService) {
        MoviesApi.INSTANCE = instance
    }
}


