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
}

