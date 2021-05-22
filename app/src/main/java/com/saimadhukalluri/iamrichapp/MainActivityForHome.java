package com.saimadhukalluri.iamrichapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class MainActivityForHome extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Button but_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_activity);
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE);
        String titleOfToolBar = sharedPreferences.getString("userName", "Avengers Profile");
        setTitle(titleOfToolBar);

        but_logout=findViewById(R.id.but_logout);
        but_logout.setOnClickListener(v -> {
            sharedPreferences.edit().clear().apply();
            Intent bridgeToLogin=new Intent(this,MainActivity.class);
            startActivity(bridgeToLogin);
            finish();
        });
    }
}