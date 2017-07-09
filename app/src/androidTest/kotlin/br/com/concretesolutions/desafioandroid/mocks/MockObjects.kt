package br.com.concretesolutions.desafioandroid.mocks

import br.com.concretesolutions.desafioandroid.util.JsonFileReader.Companion.readFixture
import br.com.concretesolutions.repository.model.Media
import br.com.concretesolutions.repository.model.Page
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MockObjects {
    companion object {

        fun mediaPage(): Page<Media> {
            val moviesPageString = readFixture("movie_page_200.json")
            val pageType = object : TypeToken<Page<Media>>() {}.type
            return Gson().fromJson<Page<Media>>(moviesPageString, pageType)
        }

        fun mediaItem(): Media {
            val movieItemString = readFixture("movie_item.json")
            return Gson().fromJson(movieItemString, Media::class.java)
        }

    }
}