package com.example.itcity.THEORY_TASK.programming;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class Thpr9 extends AppCompatActivity {

    Button continueSec;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progtheory9);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        continueSec = (Button) findViewById(R.id.continueSec);
        back = (Button) findViewById(R.id.bottomSecurityK);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomSecurityK:
                        Intent intent2 = new Intent(Thpr9.this, Programming_Home.class);
                        startActivity(intent2);
                        break;
                    case R.id.continueSec:
                        Intent intent1 = new Intent(Thpr9.this, Zadp9.class);
                        startActivity(intent1);
                        break;
                }
            }
        };
        continueSec.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}