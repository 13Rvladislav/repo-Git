package com.example.itcity.THEORY_TASK.security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;
import com.example.itcity.THEORY_TASK.algorithm.ZadanieAlgorithm3;

public class TheorySecurity1 extends AppCompatActivity {
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectheory1);
        next=findViewById(R.id.continueSec);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continueSec:
                        Intent intent = new Intent(TheorySecurity1.this,ZadanieSecurity1.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        next.setOnClickListener(onClickListener);
    }
}