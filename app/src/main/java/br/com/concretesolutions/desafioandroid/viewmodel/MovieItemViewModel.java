package br.com.concretesolutions.desafioandroid.viewmodel;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.model.Movie;

public class MovieItemViewModel implements Parcelable {

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

    public String getRating(final Context context) {
        return String.format(context.getString(R.string.movie_item_rating), rating);
    }

    public String getPoster() {
        return BuildConfig.BASE_IMAGE_URL + poster;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.rating);
        dest.writeString(this.poster);
    }

    protected MovieItemViewModel(Parcel in) {
        this.title = in.readString();
        this.rating = in.readString();
        this.poster = in.readString();
    }

    public static final Creator<MovieItemViewModel> CREATOR = new Creator<MovieItemViewModel>() {
        @Override
        public MovieItemViewModel createFromParcel(Parcel source) {
            return new MovieItemViewModel(source);
        }

        @Override
        public MovieItemViewModel[] newArray(int size) {
            return new MovieItemViewModel[size];
        }
    };
}
