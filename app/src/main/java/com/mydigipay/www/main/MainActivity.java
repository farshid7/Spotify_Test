package com.mydigipay.www.main;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.mydigipay.www.R;
import com.mydigipay.www.api.ApiService;
import com.mydigipay.www.api.entity.SearchResult;
import com.mydigipay.www.baseClass.BaseActivity;
import com.mydigipay.www.baseClass.OnUpdateData;
import com.mydigipay.www.main.adapter.SearchDataProvider;
import com.mydigipay.www.main.adapter.SearchItem;
import com.mydigipay.www.utils.AuthenticationResponseViewModel;
import com.mydigipay.www.utils.Constants;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import java.util.List;


public class MainActivity extends BaseActivity implements OnUpdateData<SearchResult> {
    private String TAG = MainActivity.class.getSimpleName();
    private AuthenticationResponseViewModel model;
    private MainPresenter mainPresenter;
    private TextView textView;
    private String keyWord;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void init() {
        setView(R.layout.activity_main);
        initView();
        setup();
    }

    private void initView() {
        progressBar = findViewById(R.id.progressBar);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.textView);
        findViewById(R.id.clear).setOnClickListener(v -> textView.setText(""));
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 2) {
                    progressBar.setVisibility(View.VISIBLE);
                    keyWord = textView.getText().toString();
                    mainPresenter.search(keyWord);
                }
            }
        });
    }

    private void setup() {
        model = ViewModelProviders.of(this).get(AuthenticationResponseViewModel.class);
        mainPresenter = new MainPresenter(ApiService.getService("no token"), this, this);
        model.getAuthenticationResponseViewModel().observe(this, authenticationResponse -> {
            mainPresenter.setNewApi(ApiService.getService(authenticationResponse.getAccessToken()));
            if (!keyWord.isEmpty()) {
                mainPresenter.search(keyWord);
            }
        });
    }

    @Override
    public void onUpdate(SearchResult body) {
        List<SearchItem>  searchItems=SearchDataProvider.Provide(body);
        Toast.makeText(this, "number of find : "+searchItems.size(), Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
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
                    model.setAuthenticationResponse(response);
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
