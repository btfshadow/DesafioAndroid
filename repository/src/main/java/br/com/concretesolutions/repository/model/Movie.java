package br.com.concretesolutions.repository.model;

import com.google.gson.annotations.Expose;

public class Movie {

    @Expose
    private String title;

    @Expose
    private String overview;

    public String title() {
        return title;
    }

    public String overview() {
        return overview;
    }
}
