package br.com.concretesolutions.desafioandroid.viewmodel;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import br.com.concretesolutions.desafioandroid.R;
import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.TVShow;

public class MediaItemViewModel<T extends Media> implements Parcelable {

    private String title;
    private String rating;
    private String poster;

    public MediaItemViewModel(@NonNull final T media) {
        if (media instanceof Movie)
            this.title = ((Movie) media).title();
        else
            this.title = ((TVShow) media).name();

        this.rating = media.rating();
        this.poster = media.poster();
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

    private MediaItemViewModel(Parcel in) {
        this.title = in.readString();
        this.rating = in.readString();
        this.poster = in.readString();
    }

    public static final Creator<MediaItemViewModel> CREATOR = new Creator<MediaItemViewModel>() {
        @Override
        public MediaItemViewModel createFromParcel(Parcel source) {
            return new MediaItemViewModel(source);
        }

        @Override
        public MediaItemViewModel[] newArray(int size) {
            return new MediaItemViewModel[size];
        }
    };
}
