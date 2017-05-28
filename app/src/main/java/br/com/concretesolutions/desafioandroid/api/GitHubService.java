package br.com.concretesolutions.desafioandroid.api;

import br.com.concretesolutions.desafioandroid.model.Page;
import br.com.concretesolutions.desafioandroid.model.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface GitHubService {
    @GET("search/repositories")
    Call<Page<Repo>> searchRepos(@Query("q") @LanguageType String language, @Query("sort") @SortType String sort, @Query("page") int page);
}
