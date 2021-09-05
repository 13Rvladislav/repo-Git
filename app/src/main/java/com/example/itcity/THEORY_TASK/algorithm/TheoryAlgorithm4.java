package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class TheoryAlgorithm4 extends AppCompatActivity {

    Button button7;
    Button bottomTeoryK4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.algtheory4);
        getSupportActionBar().hide();
        button7 = (Button) findViewById(R.id.button7);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button7:
                        Intent intent1 = new Intent(TheoryAlgorithm4.this, ZadanieAlgorithm4.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomTeoryK4:
                        Intent intent2 = new Intent(TheoryAlgorithm4.this, Algorithm_HOME.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        button7.setOnClickListener(onClickListener);
        bottomTeoryK4.setOnClickListener(onClickListener);
    }
}