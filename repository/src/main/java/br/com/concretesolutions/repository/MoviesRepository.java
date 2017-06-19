package br.com.concretesolutions.repository;


import br.com.concretesolutions.repository.api.MoviesApi;
import br.com.concretesolutions.repository.api.MoviesService;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.api.type.RegionType;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;

public final class MoviesRepository {

    private MoviesRepository() {
    }

    public static Observable<Page<Movie>> popular(@LanguageType final String language, int page, @RegionType final String region) {
        return API().getPopularMovies(language, page, region);
    }

    public static Observable<Page<Movie>> nowPlaying(@LanguageType final String language, int page, @RegionType final String region) {
        return API().getNowPlaying(language, page, region);
    }

    public static Observable<Page<Movie>> topRated(@LanguageType final String language, int page, @RegionType final String region) {
        return API().getTopRatedMovies(language, page, region);
    }

    public static Observable<Page<Movie>> upComing(@LanguageType final String language, int page, @RegionType final String region) {
        return API().getUpcoming(language, page, region);
    }

    private static MoviesService API() {
        return MoviesApi.get();
    }
}
