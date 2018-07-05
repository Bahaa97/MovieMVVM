package com.example.bahaa.mvvm_movie.ui.mainsceen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.bahaa.mvvm_movie.R;
import com.example.bahaa.mvvm_movie.callback.OnMovieRetrevierLisener;
import com.example.bahaa.mvvm_movie.model.Movie;
import com.example.bahaa.mvvm_movie.util.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_recycle)
    RecyclerView mainRecycle;
    private MainViewModel model;
    private MainAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        model = new MainViewModel();
        getMovie(Constants.POPULER_KEY);
    }

    private void getMovie(String movieType) {
        model.getMovieDataFromApi(movieType, new OnMovieRetrevierLisener() {
            @Override
            public void onSucces(List<Movie> movies) {
                mainRecycle.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                adaptor=new MainAdaptor(MainActivity.this,movies);
                mainRecycle.setAdapter(adaptor);
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
