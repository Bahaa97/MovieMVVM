package com.example.bahaa.mvvm_movie.data.remote;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.bahaa.mvvm_movie.callback.OnMovieRetrevierLisener;
import com.example.bahaa.mvvm_movie.model.MovieRespons;
import com.example.bahaa.mvvm_movie.util.Constants;

public class ApiCall {
    public void getMovieData(String movieType, final OnMovieRetrevierLisener lisener){
        AndroidNetworking.get(Constants.BASE_URL+movieType)
                .addQueryParameter(Constants.API_KEY,Constants.API_KEY_VALUE)
                .build()
                .getAsObject(MovieRespons.class, new ParsedRequestListener<MovieRespons>() {
                    @Override
                    public void onResponse(MovieRespons response) {
                        lisener.onSucces(response.getMovieData());
                    }

                    @Override
                    public void onError(ANError anError) {
                        lisener.onError(anError.getErrorDetail());
                    }
                });

    }
}
