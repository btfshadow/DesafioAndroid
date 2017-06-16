package br.com.concretesolutions.desafioandroid.manager;

import br.com.concretesolutions.repository.MoviesRepository;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.api.type.RegionType;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MoviesManager {
    private MoviesManager() {
    }

    public static Observable<Page<Movie>> getPopular() {
        return MoviesRepository.popular(LanguageType.PT_BR, 1, RegionType.BR)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
