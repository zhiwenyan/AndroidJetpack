package com.steven.androidjetpack.example;

import android.content.Context;

import com.steven.androidjetpack.databinding.MovieItemBinding;
import com.steven.androidjetpack.example.base.BaseBindingAdapter;

import java.util.List;

/**
 * Description:
 * Data：10/12/2018-4:20 PM
 *
 * @author yanzhiwen
 */
public class MovieListAdapter extends BaseBindingAdapter<Movie,MovieItemBinding> {


    public MovieListAdapter(Context context, List<Movie> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void onBindItem(MovieItemBinding binding, Movie item) {
        binding.setMovie(item);
    }
}
