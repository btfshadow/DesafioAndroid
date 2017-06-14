package br.com.concretesolutions.repository;


import android.support.annotation.NonNull;

import br.com.concretesolutions.repository.api.MoviesApi;
import br.com.concretesolutions.repository.api.MoviesService;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.api.type.RegionType;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.Page;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class MoviesRepository {

    private MoviesRepository() {
    }

    public static void nowPlaying(@LanguageType final String language, int page, @RegionType final String region) {
        API().getNowPlaying(language, page, region)
                .enqueue(new Callback<Page<Movie>>() {
                    @Override
                    public void onResponse(@NonNull Call<Page<Movie>> call, @NonNull Response<Page<Movie>> response) {
                    }

                    @Override
                    public void onFailure(@NonNull Call<Page<Movie>> call, @NonNull Throwable t) {
                    }
                });
    }

    public static void popular(@LanguageType final String language, int page, @RegionType final String region) {
        API().getPopularMovies(language, page, region)
                .enqueue(new Callback<Page<Movie>>() {
                    @Override
                    public void onResponse(@NonNull Call<Page<Movie>> call, @NonNull Response<Page<Movie>> response) {

                    }

                    @Override
                    public void onFailure(@NonNull Call<Page<Movie>> call, @NonNull Throwable t) {

                    }
                });
    }

    public static void topRated(@LanguageType final String language, int page, @RegionType final String region) {
        API().getTopRatedMovies(language, page, region)
                .enqueue(new Callback<Page<Movie>>() {
                    @Override
                    public void onResponse(@NonNull Call<Page<Movie>> call, @NonNull Response<Page<Movie>> response) {

                    }

                    @Override
                    public void onFailure(@NonNull Call<Page<Movie>> call, @NonNull Throwable t) {

                    }
                });
    }

    public static void upComing(@LanguageType final String language, int page, @RegionType final String region) {
        API().getUpcoming(language, page, region)
                .enqueue(new Callback<Page<Movie>>() {
                    @Override
                    public void onResponse(@NonNull Call<Page<Movie>> call, @NonNull Response<Page<Movie>> response) {

                    }

                    @Override
                    public void onFailure(@NonNull Call<Page<Movie>> call, @NonNull Throwable t) {

                    }
                });
    }

    private static MoviesService API() {
        return MoviesApi.get();
    }
}
