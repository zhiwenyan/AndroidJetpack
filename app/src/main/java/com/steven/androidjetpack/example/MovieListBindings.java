package com.steven.androidjetpack.example;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Description:
 * Data：10/23/2018-2:39 PM
 *
 * @author yanzhiwen
 */
public class MovieListBindings {

    @SuppressWarnings("unchecked")
    @BindingAdapter("app:items")
    public static void setItems(RecyclerView recyclerView, List<Movie> movies) {
        MovieListAdapter adapter = ( MovieListAdapter ) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addAll(movies);
        }
    }

    @BindingAdapter("app:url")
            public static void setImageViewByUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
