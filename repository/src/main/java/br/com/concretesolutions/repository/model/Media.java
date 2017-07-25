package br.com.concretesolutions.repository.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Media implements Parcelable {

    @SerializedName(value = "title", alternate = {"name"})
    private String title;

    @Expose
    private String overview;

    @SerializedName("spoken_languages")
    private List<SpokenLanguage> languages;

    @SerializedName("backdrop_path")
    private String backdrop;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("vote_average")
    private String rating;

    public String overview() {
        return overview;
    }

    public List<SpokenLanguage> languages() {
        return languages;
    }

    public String backdrop() {
        return backdrop;
    }

    public String poster() {
        return poster;
    }

    public String rating() {
        return rating;
    }

    public String title() {
        return title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeList(this.languages);
        dest.writeString(this.backdrop);
        dest.writeString(this.poster);
        dest.writeString(this.rating);
    }

    public Media() {
    }

    protected Media(Parcel in) {
        this.title = in.readString();
        this.overview = in.readString();
        this.languages = new ArrayList<SpokenLanguage>();
        in.readList(this.languages, SpokenLanguage.class.getClassLoader());
        this.backdrop = in.readString();
        this.poster = in.readString();
        this.rating = in.readString();
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel source) {
            return new Media(source);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };
}
