package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class TheoryAlgorithm6 extends AppCompatActivity {
    Button bottomTeoryK6;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtheory6);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        bottomTeoryK6 = (Button) findViewById(R.id.bottomTeoryK6);
        next = (Button) findViewById(R.id.button8);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button8:
                        Intent intent1 = new Intent(TheoryAlgorithm6.this, ZadanieAlgorithm6.class);
                        startActivity(intent1);
                        break;

                    case R.id.bottomTeoryK6:
                        Intent intent2 = new Intent(TheoryAlgorithm6.this, Algorithm_HOME.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        bottomTeoryK6.setOnClickListener(onClickListener);
        next.setOnClickListener(onClickListener);
    }
}