package com.example.itcity.THEORY_TASK.algorithm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class ZadanieAlgorithm4 extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtask4);
        getSupportActionBar().hide();
        back = (Button) findViewById(R.id.button5);



        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent = new Intent(ZadanieAlgorithm4.this, TheoryAlgorithm4.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        };
        back.setOnClickListener(onClickListener);
    }
}