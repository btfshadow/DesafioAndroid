package br.com.concretesolutions.repository.api;

import br.com.concretesolutions.repository.api.endpoint.MovieEndpoints;
import br.com.concretesolutions.repository.api.endpoint.TVShowEndpoints;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.api.type.RegionType;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MediaService {

    // Movies
    @GET(MovieEndpoints.popular)
    Observable<Page<Media>> getPopularMovies(
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    @GET(MovieEndpoints.nowPlaying)
    Observable<Page<Media>> getNowPlaying(
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    @GET(MovieEndpoints.topRated)
    Observable<Page<Media>> getTopRatedMovies(
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    @GET(MovieEndpoints.upcoming)
    Observable<Page<Media>> getUpcoming(
            @Query("language") @LanguageType String language,
            @Query("page") int page,
            @Query("region") @RegionType String region);

    // TV Shows
    @GET(TVShowEndpoints.popular)
    Observable<Page<Media>> getPopularTVShows(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.topRated)
    Observable<Page<Media>> getTopRatedTVShows(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.airingToday)
    Observable<Page<Media>> getAiringToday(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

    @GET(TVShowEndpoints.onTheAir)
    Observable<Page<Media>> getOnTheAir(
            @Query("language") @LanguageType String language,
            @Query("page") int page);

}
