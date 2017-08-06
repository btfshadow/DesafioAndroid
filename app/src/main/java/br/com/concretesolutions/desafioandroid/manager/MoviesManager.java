package br.com.concretesolutions.desafioandroid.manager;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.repository.MoviesRepository;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.api.type.RegionType;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static br.com.concretesolutions.desafioandroid.manager.MoviesManager.MovieCategoryType.NOW_PLAYING;
import static br.com.concretesolutions.desafioandroid.manager.MoviesManager.MovieCategoryType.POPULAR;
import static br.com.concretesolutions.desafioandroid.manager.MoviesManager.MovieCategoryType.TOP_RATED;
import static br.com.concretesolutions.desafioandroid.manager.MoviesManager.MovieCategoryType.UP_COMING;

public class MoviesManager {

    private MoviesManager() {
    }

    @Retention(RetentionPolicy.CLASS)
    @IntDef({POPULAR, TOP_RATED, NOW_PLAYING, UP_COMING})
    public @interface MovieCategoryType {
        int POPULAR = R.string.popular;
        int TOP_RATED = R.string.top_rated;
        int NOW_PLAYING = R.string.now_playing;
        int UP_COMING = R.string.up_coming;
    }

    public static Observable<Page<Media>> get(@MovieCategoryType int category, int page) throws NoSuchMethodException {
        switch (category) {
            case POPULAR:
                return getPopular(page);
            case TOP_RATED:
                return getTopRated(page);
            case NOW_PLAYING:
                return getNowPlaying(page);
            case UP_COMING:
                return getUpComing(page);
            default:
                throw new NoSuchMethodException("There is no category type " + category + " in MoviesManager");
        }
    }

    private static Observable<Page<Media>> getPopular(int page) {
        return MoviesRepository.popular(LanguageType.PT_BR, page, RegionType.BR)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static Observable<Page<Media>> getNowPlaying(int page) {
        return MoviesRepository.nowPlaying(LanguageType.PT_BR, page, RegionType.BR)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static Observable<Page<Media>> getTopRated(int page) {
        return MoviesRepository.topRated(LanguageType.PT_BR, page, RegionType.BR)
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static Observable<Page<Media>> getUpComing(int page) {
        return MoviesRepository.upComing(LanguageType.PT_BR, page, RegionType.BR)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
