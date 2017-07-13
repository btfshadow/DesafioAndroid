package br.com.concretesolutions.repository.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpokenLanguage implements Parcelable{

    @Expose private String name;
    @Expose @SerializedName("iso_639_1") private String iso;

    public String name() {
        return name;
    }

    public String iso() {
        return iso;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.iso);
    }

    public SpokenLanguage() {
    }

    protected SpokenLanguage(Parcel in) {
        this.name = in.readString();
        this.iso = in.readString();
    }

    public static final Creator<SpokenLanguage> CREATOR = new Creator<SpokenLanguage>() {
        @Override
        public SpokenLanguage createFromParcel(Parcel source) {
            return new SpokenLanguage(source);
        }

        @Override
        public SpokenLanguage[] newArray(int size) {
            return new SpokenLanguage[size];
        }
    };
}
