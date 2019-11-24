package com.mydigipay.www.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitCallBack {
    public static <R> void callRetrofit(Call<R> call, final Context context, final RetrofitObject<R> retrofitObject) {
        call.enqueue(new Callback<R>() {
            @Override
            public void onResponse(@NonNull final Call<R> call, @NonNull Response<R> response) {
                if (response.isSuccessful()) {
                    retrofitObject.onSuccess(response.body());
                } else if (response.code() == 401) {
                    retrofitObject.unauthorized();
                } else {
                    retrofitObject.onFailure(0, "respons code :" + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<R> call, @NonNull Throwable t) {
                new AlertDialog.Builder(context)
                        .setCancelable(false)
                        .setTitle("network error")
                        .setMessage(t.toString())
                        .setPositiveButton("retry", (dialog, which) -> {
                            call.cancel();
                            call.clone().enqueue(this);
                        })
                        .setNegativeButton("close app", (dialog, which) -> ((Activity) context).finish())
                        .show();
            }
        });
    }


}


