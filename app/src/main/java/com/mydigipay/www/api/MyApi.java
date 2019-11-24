package com.mydigipay.www.api;

import com.mydigipay.www.api.entity.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {


    @GET("/v1/search?type=artist,track")
    Call<SearchResult> search(@Query("q") String keyWord);

}
