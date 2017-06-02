package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.robots.pullRequests


@org.junit.runner.RunWith(org.junit.runners.JUnit4::class)
class GetPullRequestsTest {

    @org.junit.Test
    fun endpointIsCorrect() {
        pullRequests {
            creator("creator")
            repository("repo")
        } get {
            endPointIs("repos/creator/repo/pulls")
        }
    }

    @org.junit.Test
    fun whenPassCreatorName_endpointSecondParameter_shouldBeCreator() {
        pullRequests {
            creator("creator")
            repository("repo")
        } get {
            creatorIs("creator")
        }
    }

    @org.junit.Test
    fun whenPassRepositoryName_endpointThirdParameter_shouldBeRepository() {
        pullRequests {
            creator("creator")
            repository("repo")
        } get {
            repositoryIs("repo")
        }
    }
}

