package com.mydigipay.www.api;

import com.mydigipay.www.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HeaderInterceptor {

    public static OkHttpClient.Builder Builder(String token) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClient.readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS);
        httpClient.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS);
        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(request);
        });
        return httpClient;
    }
}