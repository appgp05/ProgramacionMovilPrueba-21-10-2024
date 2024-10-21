package com.example.examen.utils;

import com.example.examen.beans.User;
import com.example.examen.login_user.data.LoginUserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/loginUsers")
    Call<LoginUserData> login(@Body User user);
}
