package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheoryAlgorithm3 extends AppCompatActivity {
    Button button7;
    Button bottomTeoryK3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.algtheory3);
        getSupportActionBar().hide();
        button7 = (Button) findViewById(R.id.button7);
        bottomTeoryK3 = (Button) findViewById(R.id.bottomTeoryK3);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button7:
                        Intent intent1 = new Intent(TheoryAlgorithm3.this, ZadanieAlgorithm3.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomTeoryK3:
                        Intent intent2 = new Intent(TheoryAlgorithm3.this, Algorithm_HOME.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        button7.setOnClickListener(onClickListener);
        bottomTeoryK3.setOnClickListener(onClickListener);
    }
}