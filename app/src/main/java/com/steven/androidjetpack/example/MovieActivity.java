package com.steven.androidjetpack.example;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.databinding.ActivityMovieBinding;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    MovieViewModel mViewModel;
    ActivityMovieBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie);
        mViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        mBinding.setViewModel(mViewModel);

//        viewModel.getLiveData(0, 15).observe(this, new Observer<List<Movie>>() {
//            @Override
//            public void onChanged(@Nullable List<Movie> subjects) {
//                showMovie(subjects);
//            }
//        });

        setupListAdapter();

        setupRefreshLayout();

    }



    private void setupListAdapter() {
        mBinding.rv.setAdapter(new MovieListAdapter(this, new ArrayList<>(0)));

    }

    private void setupRefreshLayout() {
        mBinding.refreshLayout.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.getMovies(0, 20, true);

    }

    //
//    private void showMovie(List<Movie> movies) {
//        mRv.setAdapter(new BaseRecycleAdapter<Movie>(this, movies, R.layout.movie_item) {
//            @Override
//            protected void convert(BaseViewHolder holder, Movie item, int position) {
//                holder.setText(R.id.tv_name, item.getTitle());
//                ImageView iv_movie = holder.getView(R.id.iv_movie);
//                Glide.with(MovieActivity.this)
//                        .load(item.getImages().getMedium())
//                        .into(iv_movie);
//            }
//        });
//    }
}
