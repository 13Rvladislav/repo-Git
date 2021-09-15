package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

import java.io.BufferedReader;

public class TheoryAlgorithm5 extends AppCompatActivity {
    Button button7;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtheory5);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
        button7 = (Button) findViewById(R.id.button7);
        back = (Button) findViewById(R.id.bottomTeoryK5);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button7:
                        Intent intent1 = new Intent(TheoryAlgorithm5.this, ZadanieAlgorithm5.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomTeoryK5:
                        Intent intent2 = new Intent(TheoryAlgorithm5.this, Algorithm_HOME.class);
                        startActivity(intent2);
                        break;



                }
            }
        };
        button7.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}
