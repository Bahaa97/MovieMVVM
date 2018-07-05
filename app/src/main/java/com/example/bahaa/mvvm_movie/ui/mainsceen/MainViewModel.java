package com.example.bahaa.mvvm_movie.ui.mainsceen;

import android.arch.lifecycle.ViewModel;

import com.example.bahaa.mvvm_movie.callback.OnMovieRetrevierLisener;
import com.example.bahaa.mvvm_movie.data.remote.ApiCall;
import com.example.bahaa.mvvm_movie.model.Movie;

import java.util.List;

public class MainViewModel extends ViewModel {
    private ApiCall apiCall;

    public MainViewModel() {
        apiCall=new ApiCall();
    }

    public void getMovieDataFromApi(String movieType, final OnMovieRetrevierLisener lisener){
        apiCall.getMovieData(movieType, new OnMovieRetrevierLisener() {
            @Override
            public void onSucces(List<Movie> movies) {
                lisener.onSucces(movies);
            }

            @Override
            public void onError(String errorMsg) {
                lisener.onError(errorMsg);
            }
        });

    }
}
