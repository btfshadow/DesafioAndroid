package br.com.concretesolutions.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Page<T extends Media> {

    @Expose private List<T> results;
    @Expose private int page;
    @SerializedName("total_results")
    @Expose private int totalResults;
    @SerializedName("total_pages")
    @Expose private int totalPages;

    public List<T> results() {
        return results;
    }

    public int page() {
        return page;
    }

    public int totalResults() {
        return totalResults;
    }

    public int totalPages() {
        return totalPages;
    }
}
