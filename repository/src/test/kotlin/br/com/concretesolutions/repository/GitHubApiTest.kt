package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.robots.gitHubApi


@org.junit.runner.RunWith(org.junit.runners.JUnit4::class)
class GitHubApiTest {

    @org.junit.Test
    fun baseUrl_isCorrect() {
        gitHubApi {
        } build {
           baseUrlIs(BuildConfig.BASE_URL)
        }
    }

    @org.junit.Test
    fun whenAskForPageX_pageParamShouldBe_X() {
        gitHubApi {
            page(1)
        } build {
            pageIs("1")
        }
    }

    @org.junit.Test
    fun byDefault_pageShouldBe_0() {
        gitHubApi {
            page(0)
        } build {
            pageIs("0")
        }
    }

}