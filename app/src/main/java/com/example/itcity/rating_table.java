package com.example.itcity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class rating_table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
    }
}