package com.steven.androidjetpack.example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.databinding.ActivityMovieBinding;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    private MovieViewModel mViewModel;
    private ActivityMovieBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie);
        mViewModel = new MovieViewModel();
        mBinding.setViewModel(mViewModel);

        setupListAdapter();

        setupRefreshLayout();


    }

    private void setupListAdapter() {
        mBinding.rv.setAdapter(new MovieListAdapter(this, new ArrayList<>(0), R.layout.movie_item));
    }

    private void setupRefreshLayout() {
        mBinding.refreshLayout.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorPrimaryDark));
        mBinding.refreshLayout.setScrollUpChild(mBinding.rv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.getMovies();
    }
}
