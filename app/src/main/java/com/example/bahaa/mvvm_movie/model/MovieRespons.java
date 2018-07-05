package com.example.bahaa.mvvm_movie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieRespons {
    @SerializedName("results")
    private List<Movie> movieData;
    @SerializedName("page")
    private String page;
    @SerializedName("total_pages")
    private String totalPages;
    @SerializedName("total_results")
    private String totalResults;


    public List<Movie> getMovieData() {
        return movieData;
    }

    public void setMovieData(List<Movie> movieData) {
        this.movieData = movieData;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

}
