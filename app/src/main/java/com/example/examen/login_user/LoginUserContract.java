package com.example.examen.login_user;

import com.example.examen.beans.User;

public interface LoginUserContract {
    interface view{
        void successLogin(User user);
        void failureLogin(String messageError);
    }

    interface presenter{
        void loginAction(User user);
    }

    interface model{
        interface OnLoginUserListener{
            void onFinished(User user);
            void onFailure(String messageError);
        }

        void loginUserAPI(User user, OnLoginUserListener onLoginUserListener);
    }
}
