package br.com.concretesolutions.desafioandroid.manager;

import br.com.concretesolutions.repository.model.MediaType;
import br.com.concretesolutions.repository.model.MediaTypes;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;
import io.reactivex.Observable;

public final class MediaTypeManager {

    public static Observable<Page<Media>> getMediaObservable(final MediaType mediaType, int page) throws NoSuchMethodException {
        if (mediaType.getType() == MediaTypes.MOVIE)
            //noinspection WrongConstant
            return MoviesManager.get(mediaType.getCategoryName(), page);
        else
            //noinspection WrongConstant
            return TVShowsManager.get(mediaType.getCategoryName(), page);

    }
}
