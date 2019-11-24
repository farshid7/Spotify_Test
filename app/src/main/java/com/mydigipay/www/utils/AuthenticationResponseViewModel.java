package com.mydigipay.www.utils;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.spotify.sdk.android.authentication.AuthenticationResponse;

public class AuthenticationResponseViewModel extends ViewModel {

    private String TAG = AuthenticationResponseViewModel.class.getSimpleName();
    private MutableLiveData<AuthenticationResponse> authenticationResponseMutableLiveData;

    public LiveData<AuthenticationResponse> getAuthenticationResponseViewModel() {
        if (authenticationResponseMutableLiveData == null) {
            authenticationResponseMutableLiveData = new MutableLiveData<>();
        }
        return authenticationResponseMutableLiveData;
    }

    public void setAuthenticationResponse(AuthenticationResponse authenticationResponse) {
        if(authenticationResponseMutableLiveData==null){
            getAuthenticationResponseViewModel();
        }
        authenticationResponseMutableLiveData.postValue(authenticationResponse);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }
}
