package com.mydigipay.www.utils;

import android.app.Activity;

import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

public class SpotifyAuthentication {

    private static SpotifyAuthentication Instance;
    private final Activity contextActivity;


    public static synchronized SpotifyAuthentication Builder(Activity contextActivity) {
        if (Instance == null) {
            Instance = new SpotifyAuthentication(contextActivity);
        }
        return Instance;
    }

    private SpotifyAuthentication(Activity contextActivity) {
        this.contextActivity = contextActivity;
    }

    public void loginRequest(){
        AuthenticationRequest.Builder builder = new AuthenticationRequest.Builder(Constants.CLIENT_ID, AuthenticationResponse.Type.TOKEN, Constants.REDIRECT_URI);
        builder.setScopes(new String[]{"app-remote-control"});
        AuthenticationRequest request = builder.build();
        AuthenticationClient.openLoginActivity(contextActivity, Constants.LOGIN_REQUEST_CODE, request);
    }
}
