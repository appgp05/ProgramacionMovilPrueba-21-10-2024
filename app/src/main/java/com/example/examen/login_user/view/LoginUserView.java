package com.example.examen.login_user.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examen.R;
import com.example.examen.beans.User;
import com.example.examen.login_user.LoginUserContract;
import com.example.examen.login_user.presenter.LoginUserPresenter;

public class LoginUserView extends AppCompatActivity implements LoginUserContract.view{
    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;
    private LoginUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginUserPresenter(this);
//        Toast.makeText(this, "Llego", Toast.LENGTH_LONG).show();
        initComponents();

    }

    void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                User user = new User(1, edtEmail.getText().toString(), edtPassword.getText().toString());
                presenter.loginAction(user);
            }
        });
    }

    @Override
    public void successLogin(User user) {
        Toast.makeText(this, "Correct login with email: " + user.getEmail(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void failureLogin(String messageError) {
        Toast.makeText(this, messageError, Toast.LENGTH_LONG).show();
    }
}
