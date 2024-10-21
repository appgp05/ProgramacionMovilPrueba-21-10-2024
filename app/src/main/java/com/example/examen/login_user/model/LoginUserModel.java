package com.example.examen.login_user.model;

import android.service.autofill.UserData;

import com.example.examen.beans.User;
import com.example.examen.login_user.LoginUserContract;
import com.example.examen.login_user.data.LoginUserData;
import com.example.examen.utils.ApiService;
import com.example.examen.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserModel implements LoginUserContract.model {
    private static final String ip = "http://192.168.104.70:3000/";

    @Override
    public void loginUserAPI(User user, OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitClient.getClient(ip).create(ApiService.class);

        User userL = new User();
        userL.setEmail(user.getEmail());
        userL.setPassword(user.getPassword());

        Call<LoginUserData> call = apiService.login(userL);

        call.enqueue(new Callback<LoginUserData>() {
            @Override
            public void onResponse(Call<LoginUserData> call, Response<LoginUserData> response) {

                if (response.isSuccessful()) {
                    LoginUserData myData = response.body();
                    if (myData != null && myData.getUser() != null) {
                        onLoginUserListener.onFinished(userL);
                    } else {
                        onLoginUserListener.onFailure("Doesnt find the user");
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginUserData> call, Throwable t) {
                handleNetworkError(t, onLoginUserListener);
            }
        });

    }

    private void handleNetworkError(Throwable t, OnLoginUserListener listener) {
        listener.onFailure("" + t);
    }
}
