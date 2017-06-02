package br.com.concretesolutions.desafioandroid

import br.com.concretesolutions.desafioandroid.robots.gitHubApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GitHubApiTest {

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