package br.com.concretesolutions.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {

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
}
