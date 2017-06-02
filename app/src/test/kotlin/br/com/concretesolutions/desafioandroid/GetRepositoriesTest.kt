package br.com.concretesolutions.desafioandroid

import br.com.concretesolutions.desafioandroid.api.types.LanguageType
import br.com.concretesolutions.desafioandroid.api.types.SortType
import br.com.concretesolutions.desafioandroid.robots.repositories
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetRepositoriesTest {

    @Test
    fun endpointIsCorrect() {
        repositories {
        } get {
            endpointIs("search/repositories")
        }
    }

    @Test
    fun whenLanguageIsJava_queryShouldContain_Java() {
        repositories {
            languageIs(LanguageType.JAVA)
        } get {
            languageIs("java")
        }
    }

    @Test
    fun whenLanguageIsKotlin_queryShouldContain_Kotlin() {
        repositories {
            languageIs(LanguageType.KOTLIN)
        } get {
            languageIs("kotlin")
        }
    }

    @Test
    fun whenLanguageIsPHP_queryShouldContain_PHP() {
        repositories {
            languageIs(LanguageType.PHP)
        } get {
            languageIs("php")
        }
    }

    @Test
    fun whenSortForMostStars_sortShouldBe_stars() {
        repositories {
            sortBy(SortType.STARS)
        } get {
            sortedBy("stars")
        }
    }

    @Test
    fun whenSortForMostForked_sortShouldBe_forks() {
        repositories {
            sortBy(SortType.FORKS)
        } get {
            sortedBy("forks")
        }
    }

    @Test
    fun byDefault_languageShouldBeJava() {
        repositories {
        } get {
            languageIs("java")
        }
    }

    @Test
    fun byDefault_sortShouldBeStars() {
        repositories {
        } get {
            sortedBy("stars")
        }
    }

}