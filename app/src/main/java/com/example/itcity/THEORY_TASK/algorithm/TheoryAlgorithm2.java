package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheoryAlgorithm2 extends AppCompatActivity {
    Button button7;
    Button bottomTeoryK2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.algtheory2);
        getSupportActionBar().hide();
        button7 = (Button) findViewById(R.id.button7);
        bottomTeoryK2 = (Button) findViewById(R.id.bottomTeoryK2);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button7:
                        Intent intent1 = new Intent(TheoryAlgorithm2.this, ZadanieAlgorithm2.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomTeoryK2:
                        Intent intent2 = new Intent(TheoryAlgorithm2.this, Algorithm_HOME.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        button7.setOnClickListener(onClickListener);
        bottomTeoryK2.setOnClickListener(onClickListener);
    }
}