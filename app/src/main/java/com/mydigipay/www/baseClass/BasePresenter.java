package com.mydigipay.www.baseClass;

import android.content.Context;

import com.mydigipay.www.api.MyApi;

public class BasePresenter {
    private MyApi api;
    private final Context context;

    public BasePresenter(MyApi api, Context context) {
        this.api = api;
        this.context = context;
    }
    public Context getContext(){
        return context;
    }

    public void setNewApi(MyApi api) {
        this.api = api;
    }

    public MyApi getApi() {
        return api;
    }
}
