package com.mydigipay.www.main;

import android.content.Context;

import com.mydigipay.www.api.MyApi;
import com.mydigipay.www.api.RetrofitCallBack;
import com.mydigipay.www.api.RetrofitObject;
import com.mydigipay.www.api.entity.SearchResult;
import com.mydigipay.www.baseClass.BasePresenter;
import com.mydigipay.www.baseClass.OnUpdateData;
import com.mydigipay.www.utils.SpotifyAuthentication;

public class MainPresenter extends BasePresenter {

    private final OnUpdateData<SearchResult> searchResultOnUpdateData;

    public MainPresenter(MyApi api, Context context, OnUpdateData<SearchResult> searchResultOnUpdateData) {
        super(api, context);
        this.searchResultOnUpdateData = searchResultOnUpdateData;
    }

    public void search(String keyWord) {
        RetrofitCallBack.callRetrofit(getApi().search(keyWord), getContext(), new RetrofitObject<SearchResult>() {
            @Override
            public void onSuccess(SearchResult body) {
                searchResultOnUpdateData.onUpdate(body);
            }

            @Override
            public void unauthorized() {
                SpotifyAuthentication.Builder((MainActivity) getContext()).loginRequest();
            }

            @Override
            public void onFailure(int errorCode, String message) {
                SpotifyAuthentication.Builder((MainActivity) getContext()).loginRequest();
            }
        });
    }
}
