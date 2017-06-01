package br.com.concretesolutions.desafioandroid

import br.com.concretesolutions.desafioandroid.robots.pullRequests
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetPullRequestsTest {

    @Test
    fun endpointIsCorrect() {
        pullRequests {
            creator("creator")
            repository("repo")
        } get {
            endPointIs("repos/creator/repo/pulls")
        }
    }

    @Test
    fun whenPassCreatorName_endpointSecondParameter_shouldBeCreator() {
        pullRequests {
            creator("creator")
            repository("repo")
        } get {
            creatorIs("creator")
        }
    }

    @Test
    fun whenPassRepositoryName_endpointThirdParameter_shouldBeRepository() {
        pullRequests {
            creator("creator")
            repository("repo")
        } get {
            repositoryIs("repo")
        }
    }
}

