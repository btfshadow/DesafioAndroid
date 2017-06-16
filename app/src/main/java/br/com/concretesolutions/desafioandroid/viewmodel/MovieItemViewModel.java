package br.com.concretesolutions.desafioandroid.viewmodel;

import android.support.annotation.NonNull;

import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.model.Movie;

public class MovieItemViewModel {

    private String title;
    private String rating;
    private String poster;

    public MovieItemViewModel(@NonNull final Movie movie) {
        this.title = movie.title();
        this.rating = movie.rating();
        this.poster = movie.poster();
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return "Rating: " + rating;
    }

    public String getPoster() {
        return BuildConfig.BASE_IMAGE_URL + poster;
    }
}
