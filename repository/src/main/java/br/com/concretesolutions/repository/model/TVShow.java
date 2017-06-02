package br.com.concretesolutions.repository.model;

import com.google.gson.annotations.Expose;

public class TVShow {
    @Expose
    private String name;
    @Expose
    private String overview;

    public String name() {
        return name;
    }

    public String overview() {
        return overview;
    }
}
