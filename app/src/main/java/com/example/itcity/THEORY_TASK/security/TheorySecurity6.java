package com.example.itcity.THEORY_TASK.security;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class TheorySecurity6 extends AppCompatActivity {
    Button continieSec6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sectheory6);
        getSupportActionBar().hide();
        continieSec6 = (Button) findViewById(R.id.continieSec6);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec6:
                        Intent intent1 = new Intent(TheorySecurity6.this, ZadanieSecurity6.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        continieSec6.setOnClickListener(onClickListener);
    }
}
