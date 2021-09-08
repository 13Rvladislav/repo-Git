package com.example.itcity.THEORY_TASK.computer_Device;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheoryComputer5 extends AppCompatActivity {
    Button continieCompDev;
    Button bottomCompDevK5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtheory5);
        getSupportActionBar().hide();

        continieCompDev = (Button) findViewById(R.id.continieCompDev);
        bottomCompDevK5 = (Button) findViewById(R.id.bottomCompDevK5);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continueSec:
                        Intent intent1 = new Intent(TheoryComputer5.this, ZadanieComputer4.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomCompDevK5:
                        Intent intent2 = new Intent(TheoryComputer5.this, Computer_Home.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        continieCompDev.setOnClickListener(onClickListener);
        bottomCompDevK5.setOnClickListener(onClickListener);
    }
}