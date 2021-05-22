package com.saimadhukalluri.iamrichapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText_mobile;
    EditText editText_Pass;
    ImageView avengers_logo;
    Button bu_login;
    TextView textV_forgotPass;
    TextView textV_Register;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_activity);
        setTitle("Login");

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean("isLogin", false);
        if (isLogin) {
            Intent bridge = new Intent(this, MainActivityForHome.class);
            startActivity(bridge);
        }


        editText_mobile = findViewById(R.id.editText_mobile);
        editText_Pass = findViewById(R.id.editText_Password);
        avengers_logo = findViewById(R.id.avengers_logo);
        bu_login = findViewById(R.id.bu_login);
        textV_forgotPass = findViewById(R.id.textV_forgotPass);
        textV_Register = findViewById(R.id.textV_Register);

        bu_login.setOnClickListener(v -> {
            String mobile = String.valueOf(editText_mobile.getText());
            String pass = String.valueOf(editText_Pass.getText());

            if (mobile.equals("9542035647") && pass.equals("123")) {
                sharedPreferences.edit().putBoolean("isLogin", true).apply();
                sharedPreferences.edit().putString("userName", "sai madhu Tony").apply();
                Toast.makeText(this, "successfully logged in", Toast.LENGTH_SHORT).show();
                Intent bridge = new Intent(this, MainActivityForHome.class);
                startActivity(bridge);
            } else {
                Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
