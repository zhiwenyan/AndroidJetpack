package com.steven.androidjetpack.example;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


//https://api.douban.com/v2/movie/top250?start=0&count=10

public interface ServiceApi {
    @GET("top250")
    Call<HttpResult<List<Movie>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
