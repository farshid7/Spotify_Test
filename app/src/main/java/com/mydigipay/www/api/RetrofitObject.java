package com.mydigipay.www.api;


public interface RetrofitObject<B> {

    void onSuccess(B body);

    void unauthorized();

    void onFailure(int errorCode, String message);
}
