package br.com.concretesolutions.desafioandroid.model;

import com.google.gson.annotations.Expose;

public class PullRequest {
    @Expose
    private String title;
    @Expose
    private String body;

    public String title() {
        return title;
    }

    public String body() {
        return body;
    }
}
