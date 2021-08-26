package com.example.itcity.THEORY_TASK.security;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class TheorySecurity5 extends AppCompatActivity {
    Button continieSec5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sectheory5);
        getSupportActionBar().hide();
        continieSec5 = (Button) findViewById(R.id.continieSec5);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec5:
                        Intent intent1 = new Intent(TheorySecurity5.this, ZadanieSecurity5.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        continieSec5.setOnClickListener(onClickListener);
    }
}
