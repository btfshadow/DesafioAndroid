package br.com.concretesolutions.desafioandroid.viewmodel;

import android.support.annotation.NonNull;

import java.util.List;

import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.SpokenLanguage;

public class LatestMovieViewModel {

    private String title;
    private String overview;
    private String language;
    private String imageUrl;

    public LatestMovieViewModel(@NonNull final Movie movie) {
        this.title = movie.title();
        this.overview = movie.overview();

        final List<SpokenLanguage> languages = movie.languages();
        if (languages.size() > 0)
            this.language = languages.get(0).name();
        else this.language = "";

        this.imageUrl = movie.imageUrl();
    }

    public String title() {
        return title;
    }

    public String overview() {
        return overview;
    }

    public String language() {
        return language;
    }

    public String imageUrl() {
        return BuildConfig.BASE_IMAGE_URL + imageUrl;
    }
}
