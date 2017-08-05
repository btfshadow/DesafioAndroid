package br.com.concretesolutions.desafioandroid.ui.feature.media;

import java.util.ArrayList;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.repository.model.MediaType;

import static br.com.concretesolutions.repository.model.MediaTypes.MOVIE;
import static br.com.concretesolutions.repository.model.MediaTypes.TV;

public final class MediaCategoriesBuilder {

    public static ArrayList<MediaType> buildMovies() {
        return new ArrayList<MediaType>() {{
            add(new MediaType(R.string.popular, MOVIE));
            add(new MediaType(R.string.now_playing, MOVIE));
            add(new MediaType(R.string.top_rated, MOVIE));
            add(new MediaType(R.string.up_coming, MOVIE));
        }};
    }

    public static ArrayList<MediaType> buildTVShows() {
        return new ArrayList<MediaType>() {{
            add(new MediaType(R.string.popular, TV));
            add(new MediaType(R.string.top_rated, TV));
            add(new MediaType(R.string.airing_today, TV));
            add(new MediaType(R.string.on_the_air, TV));
        }};
    }

    private MediaCategoriesBuilder() {
    }
}
