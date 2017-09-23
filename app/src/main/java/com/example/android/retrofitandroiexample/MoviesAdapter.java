package com.example.android.retrofitandroiexample;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.retrofitandroiexample.com.pojo.SongsItem;

import java.util.ArrayList;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    public ArrayList<SongsItem> movies;
    public int rowLayout;
    public Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    public MoviesAdapter( int rowLayout, Context context) {
        this.rowLayout = rowLayout;
        this.context = context;
        movies = new ArrayList<>();

    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getSongName());
        holder.data.setText(movies.get(position).getSongLink());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public void addSongs(ArrayList<SongsItem> songsItems){
        movies.addAll(songsItems);
        Log.d("data" , ""+movies.size());
    }

    public ArrayList<SongsItem> getMovieList() {
        return movies;
    }
}