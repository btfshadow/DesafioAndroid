package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.robots.repositories


@org.junit.runner.RunWith(org.junit.runners.JUnit4::class)
class GetRepositoriesTest {

    @org.junit.Test
    fun endpointIsCorrect() {
        repositories {
        } get {
            endpointIs("search/repositories")
        }
    }

    @org.junit.Test
    fun whenLanguageIsJava_queryShouldContain_Java() {
        repositories {
            languageIs(br.com.concretesolutions.desafioandroid.api.types.LanguageType.JAVA)
        } get {
            languageIs("java")
        }
    }

    @org.junit.Test
    fun whenLanguageIsKotlin_queryShouldContain_Kotlin() {
        repositories {
            languageIs(br.com.concretesolutions.desafioandroid.api.types.LanguageType.KOTLIN)
        } get {
            languageIs("kotlin")
        }
    }

    @org.junit.Test
    fun whenLanguageIsPHP_queryShouldContain_PHP() {
        repositories {
            languageIs(br.com.concretesolutions.desafioandroid.api.types.LanguageType.PHP)
        } get {
            languageIs("php")
        }
    }

    @org.junit.Test
    fun whenSortForMostStars_sortShouldBe_stars() {
        repositories {
            sortBy(br.com.concretesolutions.desafioandroid.api.types.SortType.STARS)
        } get {
            sortedBy("stars")
        }
    }

    @org.junit.Test
    fun whenSortForMostForked_sortShouldBe_forks() {
        repositories {
            sortBy(br.com.concretesolutions.desafioandroid.api.types.SortType.FORKS)
        } get {
            sortedBy("forks")
        }
    }

    @org.junit.Test
    fun byDefault_languageShouldBeJava() {
        repositories {
        } get {
            languageIs("java")
        }
    }

    @org.junit.Test
    fun byDefault_sortShouldBeStars() {
        repositories {
        } get {
            sortedBy("stars")
        }
    }

}