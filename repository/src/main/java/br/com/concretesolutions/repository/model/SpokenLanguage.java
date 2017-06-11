package br.com.concretesolutions.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {

    @Expose private String name;
    @Expose @SerializedName("iso_639_1") private String iso;

    public String name() {
        return name;
    }

    public String iso() {
        return iso;
    }
}
