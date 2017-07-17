package br.com.concretesolutions.desafioandroid.manager;

import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;

public final class MediaManagerTypeHandler {

    public static Observable<Page<Media>> getManagerObservable(@MediaManagerType int managerType, int category, int page) throws NoSuchMethodException {
        if (managerType == MediaManagerType.MOVIE)
            return MoviesManager.get(category, page);
        else
            return TVShowsManager.get(category, page);

    }
}
