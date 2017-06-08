package br.com.concretesolutions.repository.api

object MoviesApiInstance {

    fun instance(instance: MoviesService) {
        MoviesApi.INSTANCE = instance
    }
}


