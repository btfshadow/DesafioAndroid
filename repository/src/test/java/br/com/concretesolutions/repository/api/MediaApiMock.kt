package br.com.concretesolutions.repository.api

class MediaApiMock {
    companion object {
        fun mock(moviesApi: MediaService) {
            MediaApi.INSTANCE = moviesApi
        }

        fun reset() {
            MediaApi.INSTANCE = null
        }
    }
}