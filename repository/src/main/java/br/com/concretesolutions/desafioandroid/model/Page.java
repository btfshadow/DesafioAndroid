package br.com.concretesolutions.desafioandroid.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Page<T> {

    @Expose private List<T> items;

    public List<T> items() {
        return items;
    }
}
