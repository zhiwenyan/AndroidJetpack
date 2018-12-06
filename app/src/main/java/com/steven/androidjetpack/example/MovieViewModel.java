package com.steven.androidjetpack.example;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import com.steven.androidjetpack.BR;

/**
 * Description:
 * Data：10/16/2018-10:43 AM
 *
 * @author yanzhiwen
 */
public class MovieViewModel extends BaseObservable {
    private int start = 20;
    public final ObservableBoolean dataLoading = new ObservableBoolean(false);
    public final ObservableArrayList<Movie> items = new ObservableArrayList<>();

    public void getMovies() {
        loadMovie(0, true, false);
    }

    public void loadMoreMovies() {
        loadMovie(start, false, true);
        this.start += 20;
    }

    private void loadMovie(int start, boolean showLoading, boolean loadMore) {
        if (showLoading) {
            dataLoading.set(true);
        }
        MovieRepository.getInstance().getTopMovie(start, 20, movies -> {
            if (showLoading) {
                dataLoading.set(false);
            }
            items.clear();
            items.addAll(movies);
            notifyPropertyChanged(BR.viewModel);

        });
    }
}
