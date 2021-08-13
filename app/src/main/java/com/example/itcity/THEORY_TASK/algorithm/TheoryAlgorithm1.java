package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheoryAlgorithm1 extends AppCompatActivity {
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.algtheory1);
        getSupportActionBar().hide();
        button8 = (Button) findViewById(R.id.button8);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button8:
                        Intent intent1 = new Intent(TheoryAlgorithm1.this, ZadanieAlgorithm1.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        button8.setOnClickListener(onClickListener);
    }
}