package br.com.concretesolutions.desafioandroid.api;

import br.com.concretesolutions.desafioandroid.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubApi {

    private static GitHubService INSTANCE;

    public static GitHubService get() {
        if (INSTANCE == null) {
            INSTANCE = build();
        }
        return INSTANCE;
    }

    private static GitHubService build() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GitHubService.class);
    }
}
