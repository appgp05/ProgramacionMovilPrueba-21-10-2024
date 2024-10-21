package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.examen.login_user.view.LoginUserView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        Intent mainIntent = new Intent(MainActivity.this,
                LoginUserView.class);
        startActivity(mainIntent);
//        Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();

    }
}