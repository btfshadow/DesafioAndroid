package br.com.concretesolutions.desafioandroid

import br.com.concretesolutions.desafioandroid.api.LanguageType
import br.com.concretesolutions.desafioandroid.api.SortType
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
    fun whenLanguageIsJava_queryShouldContain_Java() {
        gitHubApi {
            languageIs(LanguageType.JAVA)
        } build {
            languageIs("language:java")
        }
    }

    @Test
    fun whenLanguageIsKotlin_queryShouldContain_Kotlin() {
        gitHubApi {
            languageIs(LanguageType.KOTLIN)
        } build {
            languageIs("language:kotlin")
        }
    }

    @Test
    fun whenLanguageIsPHP_queryShouldContain_PHP() {
        gitHubApi {
            languageIs(LanguageType.PHP)
        } build {
            languageIs("language:php")
        }
    }

    @Test
    fun whenSortForMostStars_sortShouldContain_stars() {
        gitHubApi {
            sortBy(SortType.STARS)
        } build {
            sortedBy("stars")
        }
    }

    @Test
    fun whenSortForMostForked_sortShouldContain_forks() {
        gitHubApi {
            sortBy(SortType.FORKS)
        } build {
            sortedBy("forks")
        }
    }
}