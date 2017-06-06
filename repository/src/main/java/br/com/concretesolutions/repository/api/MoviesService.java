package br.com.concretesolutions.repository.api;

import br.com.concretesolutions.repository.api.endpoint.MovieEndpoints;
import br.com.concretesolutions.repository.api.endpoint.TVShowEndpoints;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.api.type.RegionType;
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
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    @GET(MovieEndpoints.nowPlaying)
    Call<Page<Movie>> getNowPlaying(
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    @GET(MovieEndpoints.popular)
    Call<Page<Movie>> getPopular(
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    @GET(MovieEndpoints.topRated)
    Call<Page<Movie>> getTopRated(
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    @GET(MovieEndpoints.upcoming)
    Call<Page<Movie>> getUpcoming(
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    // TV Shows
    @GET(TVShowEndpoints.latest)
    Call<TVShow> getLatest(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.airingToday)
    Call<Page<TVShow>> getAiringToday(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.onTheAir)
    Call<Page<TVShow>> getOnTheAir(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.popular)
    Call<Page<TVShow>> getPopular(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.topRated)
    Call<Page<TVShow>> getTopRated(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

}
