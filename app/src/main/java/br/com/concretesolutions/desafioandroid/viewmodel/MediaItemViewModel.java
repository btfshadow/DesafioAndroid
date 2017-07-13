package br.com.concretesolutions.desafioandroid.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.model.Media;

public class MediaItemViewModel implements Parcelable {

    private String title;
    private String rating;
    private String poster;

    public MediaItemViewModel(@NonNull final Media media) {
        this.title = media.title();
        this.rating = media.rating();
        this.poster = media.poster();
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
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
