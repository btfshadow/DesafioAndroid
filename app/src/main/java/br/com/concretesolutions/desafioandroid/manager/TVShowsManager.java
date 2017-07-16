package br.com.concretesolutions.desafioandroid.manager;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.repository.TVShowsRepository;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static br.com.concretesolutions.desafioandroid.manager.TVShowsManager.TVCategoryType.AIRING_TODAY;
import static br.com.concretesolutions.desafioandroid.manager.TVShowsManager.TVCategoryType.ON_THE_AIR;
import static br.com.concretesolutions.desafioandroid.manager.TVShowsManager.TVCategoryType.POPULAR;
import static br.com.concretesolutions.desafioandroid.manager.TVShowsManager.TVCategoryType.TOP_RATED;

public class TVShowsManager {

    @Retention(RetentionPolicy.CLASS)
    @IntDef({POPULAR, TOP_RATED, AIRING_TODAY, ON_THE_AIR})
    public @interface TVCategoryType {
        int POPULAR = R.string.popular;
        int TOP_RATED = R.string.top_rated;
        int AIRING_TODAY = R.string.airing_today;
        int ON_THE_AIR = R.string.on_the_air;
    }

    public static Observable<Page<Media>> get(@TVCategoryType int category, int page) throws NoSuchMethodException {
        switch (category) {
            case POPULAR:
                return getPopular(page);
            case TOP_RATED:
                return getTopRated(page);
            case AIRING_TODAY:
                return getAiringToday(page);
            case ON_THE_AIR:
                return getOnTheAir(page);
            default:
                throw new NoSuchMethodException("There is no category type " + category + " in TVShowsManager");
        }
    }

    private static Observable<Page<Media>> getPopular(int page) {
        return TVShowsRepository.popular(LanguageType.PT_BR, page)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static Observable<Page<Media>> getTopRated(int page) {
        return TVShowsRepository.topRated(LanguageType.PT_BR, page)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static Observable<Page<Media>> getAiringToday(int page) {
        return TVShowsRepository.airingToday(LanguageType.PT_BR, page)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static Observable<Page<Media>> getOnTheAir(int page) {
        return TVShowsRepository.onTheAir(LanguageType.PT_BR, page)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
