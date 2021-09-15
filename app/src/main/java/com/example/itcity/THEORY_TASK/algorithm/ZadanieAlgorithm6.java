package com.example.itcity.THEORY_TASK.algorithm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class ZadanieAlgorithm6 extends AppCompatActivity {
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtask6);
        getSupportActionBar().hide();
        back = findViewById(R.id.button5);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent2 = new Intent(ZadanieAlgorithm6.this, TheoryAlgorithm6.class);
                        startActivity(intent2);
                        break;


                }
            }
        };

        back.setOnClickListener(onClickListener);
    }
}
