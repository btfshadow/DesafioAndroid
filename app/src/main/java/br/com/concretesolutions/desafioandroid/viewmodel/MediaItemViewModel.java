package br.com.concretesolutions.desafioandroid.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.com.concretesolutions.repository.BuildConfig;
import br.com.concretesolutions.repository.model.Media;
import br.com.concretesolutions.repository.model.Page;

public class MediaItemViewModel implements Parcelable {

    private String title;
    private String rating;
    private String poster;
    private String overview;

    public MediaItemViewModel(@NonNull final Media media) {
        this.title = media.title();
        this.rating = media.rating();
        this.poster = media.poster();
        this.overview = media.overview();
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

    public String getOverview() {
        return overview;
    }

    public static List<MediaItemViewModel> getViewModelList(final Page<Media> mediaPage) {
        List<MediaItemViewModel> viewModelList = new ArrayList<>();

        for (Media media : mediaPage.results())
            viewModelList.add(new MediaItemViewModel(media));

        return viewModelList;
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
        dest.writeString(this.overview);
    }

    protected MediaItemViewModel(Parcel in) {
        this.title = in.readString();
        this.rating = in.readString();
        this.poster = in.readString();
        this.overview = in.readString();
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
