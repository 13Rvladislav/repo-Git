package com.example.itcity.THEORY_TASK.security;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class TheorySecurity8 extends AppCompatActivity {
    Button continieSec8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sectheory8);
        getSupportActionBar().hide();
        continieSec8 = (Button) findViewById(R.id.continieSec8);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec8:
                        Intent intent1 = new Intent(TheorySecurity8.this, ZadanieSecurity8.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        continieSec8.setOnClickListener(onClickListener);
    }
}
