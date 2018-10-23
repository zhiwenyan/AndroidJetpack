package com.steven.androidjetpack.example;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.databinding.MovieItemBinding;

import java.util.List;

/**
 * Description:
 * Data：10/12/2018-4:20 PM
 *
 * @author yanzhiwen
 */
public class MovieListAdapter extends RecyclerView.Adapter {
    private LayoutInflater mLayoutInflater;
    private List<Movie> mMovies;

    public MovieListAdapter(Context context, List<Movie> movies) {
        this.mLayoutInflater = LayoutInflater.from(context);
        addAll(movies);
    }

    public MovieListAdapter(Context context, MovieViewModel viewModel) {
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemBinding binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.movie_item, parent, false);
        return new MovieUserHolder(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieItemBinding binding = DataBindingUtil.getBinding(holder.itemView);
        binding.setMovie(this.mMovies.get(position));
        //及时刷新
        binding.executePendingBindings();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mMovies == null ? 0 : mMovies.size();
    }

    public void addAll(List<Movie> movies) {
        mMovies = movies;
        notifyDataSetChanged();
    }

    public void add(Movie movie) {
        mMovies.add(0, movie);
        notifyItemInserted(0);
    }

    public void remove() {
        mMovies.remove(mMovies.size() - 1);
        notifyItemRemoved(mMovies.size() - 1);
    }

    static class MovieUserHolder extends RecyclerView.ViewHolder {
        public MovieUserHolder(View itemView) {
            super(itemView);
        }
    }

}
