package br.com.concretesolutions.repository.model;

import com.google.gson.annotations.Expose;

public class Movie extends Media {

    @Expose
    private String title;

    public String title() {
        return title;
    }

}
