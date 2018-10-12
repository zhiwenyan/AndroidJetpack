package com.steven.androidjetpack.DataBinding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Description:
 * Data：10/12/2018-5:18 PM
 *
 * @author yanzhiwen
 */
public class MyBindingAdapter {
    @BindingAdapter({"app:url", "app:placeHolder"})
    public static void LoadImageByUrl(ImageView imageView, String url, Drawable drawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(drawable)
                .into(imageView);
    }
}
