package br.com.concretesolutions.repository.model;

import com.google.gson.annotations.Expose;

public class TVShow extends Media {

    @Expose
    private String name;

    public String name() {
        return name;
    }

}
