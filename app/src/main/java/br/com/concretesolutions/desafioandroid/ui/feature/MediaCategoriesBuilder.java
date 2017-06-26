package br.com.concretesolutions.desafioandroid.ui.feature;

import java.util.ArrayList;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.desafioandroid.viewmodel.CategoryViewModel;

import static br.com.concretesolutions.desafioandroid.manager.MediaManagerType.MOVIE;
import static br.com.concretesolutions.desafioandroid.manager.MediaManagerType.TV;

public class MediaCategoriesBuilder {

    public static ArrayList<CategoryViewModel> buildMovies() {
        return new ArrayList<CategoryViewModel>() {{
            add(new CategoryViewModel(R.string.popular, MOVIE));
            add(new CategoryViewModel(R.string.now_playing, MOVIE));
            add(new CategoryViewModel(R.string.top_rated, MOVIE));
            add(new CategoryViewModel(R.string.up_coming, MOVIE));
        }};
    }

    public static ArrayList<CategoryViewModel> buildTVShows() {
        return new ArrayList<CategoryViewModel>() {{
            add(new CategoryViewModel(R.string.popular, TV));
            add(new CategoryViewModel(R.string.top_rated, TV));
            add(new CategoryViewModel(R.string.airing_today, TV));
            add(new CategoryViewModel(R.string.on_the_air, TV));
        }};
    }

    private MediaCategoriesBuilder() {
    }
}
