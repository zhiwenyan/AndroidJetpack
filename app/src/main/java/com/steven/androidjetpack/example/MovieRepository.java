package com.steven.androidjetpack.example;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Description:
 * Data：10/16/2018-10:45 AM
 *
 * @author yanzhiwen
 */
public class MovieRepository {
    private final ServiceApi mServiceApi = RetrofitClient.getServiceApi();

    private final MutableLiveData<List<Subject>> movies = new MutableLiveData<>();

    private static final MovieRepository sInstance = new MovieRepository();

    private MovieRepository() {

    }

    public static MovieRepository getInstance() {
        return sInstance;
    }

    public LiveData<List<Subject>> getTopMovie(int start, int count) {
        mServiceApi.getTopMovie(start, count).enqueue(new Callback<HttpResult<List<Subject>>>() {
            @Override
            public void onResponse(@NonNull Call<HttpResult<List<Subject>>> call,
                                   @NonNull Response<HttpResult<List<Subject>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    movies.setValue(response.body().getSubjects());
                }
            }

            @Override
            public void onFailure(@NonNull Call<HttpResult<List<Subject>>> call,
                                  @NonNull Throwable t) {
            }
        });
        return movies;
    }
}
