package br.com.concretesolutions.desafioandroid.api;

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
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GitHubService.class);
    }
}
