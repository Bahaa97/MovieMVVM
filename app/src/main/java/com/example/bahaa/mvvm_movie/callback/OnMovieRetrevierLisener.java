package com.example.bahaa.mvvm_movie.callback;

import com.example.bahaa.mvvm_movie.model.Movie;

import java.util.List;

public interface OnMovieRetrevierLisener {
    void onSucces(List<Movie> movies);

    void onError(String errorMsg);

}
