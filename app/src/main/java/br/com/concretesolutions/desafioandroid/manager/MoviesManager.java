package br.com.concretesolutions.desafioandroid.manager;

import android.support.annotation.NonNull;

import br.com.concretesolutions.repository.MoviesRepository;
import br.com.concretesolutions.repository.api.type.LanguageType;
import br.com.concretesolutions.repository.model.Movie;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MoviesManager {
    private MoviesManager() {
    }

    @NonNull
    public static Observable<Movie> getLatest() {
        return MoviesRepository.latest(LanguageType.EN_US)
                .observeOn(AndroidSchedulers.mainThread());
    }
}
