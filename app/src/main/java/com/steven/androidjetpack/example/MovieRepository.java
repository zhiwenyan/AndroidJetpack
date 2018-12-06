package com.steven.androidjetpack.example;

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


    private static final MovieRepository sInstance = new MovieRepository();


    public static MovieRepository getInstance() {
        return sInstance;
    }

    public void getTopMovie(int start, int count, LoadMovieCallback<List<Movie>> callback) {
        mServiceApi.getTopMovie(start, count).enqueue(new Callback<HttpResult<List<Movie>>>() {
            @Override
            public void onResponse(@NonNull Call<HttpResult<List<Movie>>> call,
                                   @NonNull Response<HttpResult<List<Movie>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    //movies.setValue(response.body().getSubjects());
                    callback.onMovieLoaded(response.body().getSubjects());
                }
            }

            @Override
            public void onFailure(@NonNull Call<HttpResult<List<Movie>>> call,
                                  @NonNull Throwable t) {
            }
        });
    }
}
