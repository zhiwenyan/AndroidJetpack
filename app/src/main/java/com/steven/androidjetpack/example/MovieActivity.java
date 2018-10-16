package com.steven.androidjetpack.example;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.steven.androidjetpack.R;
import com.steven.androidjetpack.recyclerview.BaseRecycleAdapter;
import com.steven.androidjetpack.recyclerview.BaseViewHolder;

import java.util.List;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        mRv = findViewById(R.id.rv);
        MovieViewModel viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        viewModel.getLiveData(0, 15).observe(this, this::showMovie);
    }

    private void showMovie(List<Subject> movies) {
        mRv.setAdapter(new BaseRecycleAdapter<Subject>(this, movies, R.layout.movie_item) {
            @Override
            protected void convert(BaseViewHolder holder, Subject item, int position) {
                holder.setText(R.id.tv_name, item.getTitle());
                ImageView iv_movie = holder.getView(R.id.iv_movie);
                Glide.with(MovieActivity.this)
                        .load(item.getImages().getMedium())
                        .into(iv_movie);
            }
        });
    }
}
