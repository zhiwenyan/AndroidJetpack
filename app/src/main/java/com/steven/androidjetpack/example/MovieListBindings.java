package com.steven.androidjetpack.example;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.steven.androidjetpack.example.base.BaseBindingAdapter;

import java.util.List;

/**
 * Description:
 * Data：10/23/2018-2:39 PM
 *
 * @author yanzhiwen
 */
public class MovieListBindings {

    @SuppressWarnings("unchecked")
    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Movie> movies) {
        BaseBindingAdapter adapter = ( BaseBindingAdapter ) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.addAll(movies);
        }
    }

    @BindingAdapter("url")
    public static void setImageViewByUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

}
