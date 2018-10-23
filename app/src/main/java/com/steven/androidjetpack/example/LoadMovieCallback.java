package com.steven.androidjetpack.example;

/**
 * Description:
 * Data：10/23/2018-2:28 PM
 *
 * @author yanzhiwen
 */
public interface LoadMovieCallback<T> {
    void onMovieLoaded(T result);
}
