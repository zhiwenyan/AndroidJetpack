package com.steven.androidjetpack.example;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import java.util.List;

/**
 * Description:
 * Data：10/16/2018-10:43 AM
 *
 * @author yanzhiwen
 */
public class MovieViewModel extends ViewModel {
    //    public LiveData<List<Movie>> getLiveData(int start, int count) {
//        return MovieRepository.getInstance().getTopMovie();
//    }
    public final ObservableBoolean dataLoading = new ObservableBoolean(false);

    public final ObservableArrayList<Movie> items = new ObservableArrayList<>();

    public void getMovies(int start, int count, boolean showLoading) {
        if (showLoading) {
            dataLoading.set(true);
        }
        MovieRepository.getInstance().getTopMovie(start, count, new LoadMovieCallback<List<Movie>>() {
            @Override
            public void onMovieLoaded(List<Movie> movies) {
                items.clear();
                items.addAll(movies);
                if (showLoading) {
                    dataLoading.set(false);
                }
            }
        });
    }
}
