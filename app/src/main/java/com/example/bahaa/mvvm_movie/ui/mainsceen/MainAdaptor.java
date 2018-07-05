package com.example.bahaa.mvvm_movie.ui.mainsceen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bahaa.mvvm_movie.R;
import com.example.bahaa.mvvm_movie.model.Movie;
import com.example.bahaa.mvvm_movie.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdaptor extends RecyclerView.Adapter<MainAdaptor.ViewHolder> {
    private Context context;
    private List<Movie> list;

    public MainAdaptor(Context context, List<Movie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get()
                .load(Constants.IMG_URL+list.get(position).getPoster_path())
                .into(holder.movieImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_img)
        ImageView movieImg;
        @BindView(R.id.movie_item)
        LinearLayout movieItem;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
