package com.steven.androidjetpack.example;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * Description:
 * Data：10/16/2018-10:43 AM
 *
 * @author yanzhiwen
 */
public class MovieViewModel extends ViewModel {

    public LiveData<List<Subject>> getLiveData(int start, int count) {
        return MovieRepository.getInstance().getTopMovie(start, count);
    }
}
