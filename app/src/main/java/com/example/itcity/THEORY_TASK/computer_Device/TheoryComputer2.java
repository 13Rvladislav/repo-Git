package com.example.itcity.THEORY_TASK.computer_Device;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheoryComputer2 extends AppCompatActivity {

    Button continieCompDev;
    Button bottomCompDevK2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtheory2);

        getSupportActionBar().hide();
        continieCompDev = (Button) findViewById(R.id.continieCompDev);
        bottomCompDevK2 = (Button) findViewById(R.id.bottomCompDevK2);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continueSec:
                        Intent intent1 = new Intent(TheoryComputer2.this, ZadanieComputer2.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomCompDevK2:
                        Intent intent2 = new Intent(TheoryComputer2.this, Computer_Teory_Task.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        continieCompDev.setOnClickListener(onClickListener);
        bottomCompDevK2.setOnClickListener(onClickListener);

    }
}