package br.com.concretesolutions.repository.api;

import br.com.concretesolutions.repository.api.endpoints.MovieEndpoints;
import br.com.concretesolutions.repository.api.endpoints.TVShowEndpoints;
import br.com.concretesolutions.repository.api.types.LanguageType;
import br.com.concretesolutions.repository.api.types.RegionType;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.Page;
import br.com.concretesolutions.repository.model.TVShow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {
    // Movies
    @GET(MovieEndpoints.latest)
    Call<Movie> getLatest(
            @Query("region") @RegionType String region,
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(MovieEndpoints.nowPlaying)
    Call<Page<Movie>> getNowPlaying(
            @Query("region") @RegionType String region,
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(MovieEndpoints.popular)
    Call<Movie> getPopular(
            @Query("region") @RegionType String region,
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(MovieEndpoints.topRated)
    Call<Movie> getTopRated(
            @Query("region") @RegionType String region,
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(MovieEndpoints.upcoming)
    Call<Movie> getUpcoming(
            @Query("region") @RegionType String region,
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    // TV Shows
    @GET(TVShowEndpoints.latest)
    Call<TVShow> getLatest(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.airingToday)
    Call<TVShow> getAiringToday(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.onTheAir)
    Call<TVShow> getOnTheAir(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.popular)
    Call<TVShow> getPopular(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.topRated)
    Call<TVShow> getTopRated(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

}
