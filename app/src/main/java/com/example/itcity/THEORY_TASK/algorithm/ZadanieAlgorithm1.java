package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class ZadanieAlgorithm1 extends AppCompatActivity {
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtask1);
        getSupportActionBar().hide();

        button5 = (Button) findViewById(R.id.button5);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent1 = new Intent(ZadanieAlgorithm1.this, TheoryAlgorithm1.class);
                        startActivity(intent1);
                        break;


                    default:
                        break;
                }
            }
        };
        button5.setOnClickListener(onClickListener);

    }
}