package br.com.concretesolutions.desafioandroid;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.concretesolutions.desafioandroid.api.GitHubApi;
import br.com.concretesolutions.desafioandroid.api.LanguageType;
import br.com.concretesolutions.desafioandroid.api.SortType;
import br.com.concretesolutions.desafioandroid.model.Page;
import br.com.concretesolutions.desafioandroid.model.Repo;
import retrofit2.Call;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class GitHubApiTest {

    private Call<Page<Repo>> searchRepos;

    @Before
    public void setUp() {
        searchRepos = GitHubApi.get().searchRepos(LanguageType.JAVA, SortType.STARS, 1);
    }

    @Test
    public void gitHubUrl_isCorrect() throws Exception {
        String expectedUrl = "https://api.github.com/search/repositories?q=language:java&sort=stars&page=1";
        assertEquals("Url is incorrect", requestUrl(), expectedUrl);
    }

    @Test
    public void query_isJava() throws Exception {
        assertEquals("Query is incorrect", requestQuery(), LanguageType.JAVA);
    }

    @Test
    public void sort_isStars() throws Exception {
        assertEquals("Sort is incorrect", requestSort(), SortType.STARS);
    }

    private String requestSort() {
        return searchRepos.request().url().queryParameterValue(1);
    }

    private String requestQuery() {
        return searchRepos.request().url().queryParameterValue(0);
    }

    private String requestUrl() {
        return searchRepos.request().url().toString();
    }
}