package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.robots.gitHubApi
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(org.junit.runners.JUnit4::class)
class MoviesApiTest {

    @Test
    fun baseUrl_isCorrect() {
        gitHubApi {
        } build {
           baseUrlIs(BuildConfig.BASE_URL)
        }
    }

    @Test
    fun whenAskForPageX_pageParamShouldBe_X() {
        gitHubApi {
            page(1)
        } build {
            pageIs("1")
        }
    }

    @Test
    fun byDefault_pageShouldBe_0() {
        gitHubApi {
            page(0)
        } build {
            pageIs("0")
        }
    }

}