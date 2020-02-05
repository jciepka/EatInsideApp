package com.example.eatinsideapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.eatinsideapp2.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    public static String USER = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onSeeRestaurantDetailsClicked(View v) {
        startActivity(new Intent(MainActivity.this, DetailsActivity.class));
    }

    public void onMenuClicked(View v) {
        startActivity(new Intent(MainActivity.this, MenuActivity.class));
    }

    public void onLoginClicked(View v) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
