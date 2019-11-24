package com.mydigipay.www.api;


import com.mydigipay.www.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    public static MyApi getService(String token) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.SPOTFY_URL)
                .client(HeaderInterceptor.Builder(token).build())
                .build();

        return retrofit.create(MyApi.class);
    }

}