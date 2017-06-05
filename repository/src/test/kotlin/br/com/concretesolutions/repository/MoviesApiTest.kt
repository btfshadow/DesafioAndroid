package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.robots.moviesApi
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(org.junit.runners.JUnit4::class)
class MoviesApiTest {

    @Test
    fun baseUrl_isCorrect() {
        moviesApi {
        } build {
           baseUrlIs(BuildConfig.BASE_URL)
        }
    }

    @Test
    fun whenAskForPageX_pageParamShouldBe_X() {
        moviesApi {
            page(1)
        } build {
            pageIs("1")
        }
    }

    @Test
    fun byDefault_pageShouldBe_0() {
        moviesApi {
            page(0)
        } build {
            pageIs("0")
        }
    }

    @Test
    fun byDefault_regionShouldBe_BR() {
        moviesApi {

        } build {
            regionIs("BR")
        }
    }

}