package br.com.concretesolutions.repository;


import br.com.concretesolutions.repository.api.MediaApi;
import br.com.concretesolutions.repository.api.MediaService;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;

public final class TVShowsRepository {

    private TVShowsRepository() {
    }

    public static Observable<Page<Media>> popular(@LanguageType final String language, int page) {
        return API().getPopularTVShows(language, page);
    }

    public static Observable<Page<Media>> topRated(@LanguageType final String language, int page) {
        return API().getTopRatedTVShows(language, page);
    }

    public static Observable<Page<Media>> airingToday(@LanguageType final String language, int page) {
        return API().getAiringToday(language, page);
    }

    public static Observable<Page<Media>> onTheAir(@LanguageType final String language, int page) {
        return API().getOnTheAir(language, page);
    }

    private static MediaService API() {
        return MediaApi.get();
    }
}
