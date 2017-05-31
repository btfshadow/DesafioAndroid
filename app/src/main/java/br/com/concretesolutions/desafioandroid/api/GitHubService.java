package br.com.concretesolutions.desafioandroid.api;

import br.com.concretesolutions.desafioandroid.api.types.LanguageType;
import br.com.concretesolutions.desafioandroid.api.types.SortType;
import br.com.concretesolutions.desafioandroid.model.Page;
import br.com.concretesolutions.desafioandroid.model.PullRequest;
import br.com.concretesolutions.desafioandroid.model.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {

    @GET("search/repositories")
    Call<Page<Repo>> searchRepos(@Query("q") @LanguageType String language, @Query("sort") @SortType String sort, @Query("page") int page);

    @GET("repos/{creator}/{repo}/pulls")
    Call<Page<PullRequest>> getPullRequests(@Path("creator") String ownerLogin, @Path("repo") String repositoryName);
}
