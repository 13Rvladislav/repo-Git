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
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectheory1);
        getSupportActionBar().hide();
        next=findViewById(R.id.continueSec);
        back=findViewById(R.id.bottomSecurityK);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continueSec:
                        Intent intent1 = new Intent(TheorySecurity1.this,ZadanieSecurity1.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomSecurityK:
                        Intent intent2 = new Intent(TheorySecurity1.this,Security_HOME.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}