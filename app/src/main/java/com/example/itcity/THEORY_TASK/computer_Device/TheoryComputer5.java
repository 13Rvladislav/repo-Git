package com.example.itcity.THEORY_TASK.computer_Device;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheoryComputer5 extends AppCompatActivity {
    Button next;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtheory5);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        next = (Button) findViewById(R.id.continieCompDev);
        back = (Button) findViewById(R.id.bottomCompDevK5);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieCompDev:
                        Intent intent1 = new Intent(TheoryComputer5.this,Zadcomp5.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomCompDevK5:
                        Intent intent2 = new Intent(TheoryComputer5.this, Comp_Home.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}