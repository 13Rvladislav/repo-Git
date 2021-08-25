package com.example.itcity.THEORY_TASK.security;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class TheorySecurity7 extends AppCompatActivity {
    Button continieSec7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sectheory7);
        getSupportActionBar().hide();
        continieSec7 = (Button) findViewById(R.id.continieSec7);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec7:
                        Intent intent1 = new Intent(TheorySecurity7.this, ZadanieSecurity7.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        continieSec7.setOnClickListener(onClickListener);
    }
}
