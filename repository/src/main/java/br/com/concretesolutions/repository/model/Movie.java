package br.com.concretesolutions.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @Expose
    private String title;

    @Expose
    private String overview;

    @Expose
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> languages;

    @SerializedName("poster_path")
    @Expose private String imageUrl;

    public String title() {
        return title;
    }

    public String overview() {
        return overview;
    }

    public List<SpokenLanguage> languages() {
        return languages;
    }

    public String imageUrl() {
        return imageUrl;
    }
}
