package com.mydigipay.www;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.mydigipay.www.utils.Constants;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AuthenticationRequest.Builder builder = new AuthenticationRequest.Builder(Constants.CLIENT_ID, AuthenticationResponse.Type.TOKEN, Constants.REDIRECT_URI);
        builder.setScopes(new String[]{"app-remote-control"});
        AuthenticationRequest request = builder.build();
        AuthenticationClient.openLoginActivity(this, Constants.LOGIN_REQUEST_CODE, request);



    }


    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Check if result comes from the correct activity
        if (requestCode == Constants.LOGIN_REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);

            switch (response.getType()) {
                // Response was successful and contains auth token
                case TOKEN:
                    // Handle successful response
                    Log.e("aaa", "onActivityResult: token" );
                    break;

                // Auth flow returned an error
                case ERROR:
                    // Handle error response
                    break;


                // Most likely auth flow was cancelled
                default:
                    // Handle other cases
            }
        }
    }
}
