package br.com.concretesolutions.desafioandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {

    @Expose
    private String name;

    @Expose
    @SerializedName("full_name")
    private String fullName;

    public String name() {
        return name;
    }

    public String fullName() {
        return fullName;
    }
}
