package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class ZadInf1 extends AppCompatActivity {
    Button next;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.inftask1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        next = findViewById(R.id.algCheck);
        back = findViewById(R.id.bottomTeoryK1);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.algCheck:
                        //Intent intent = new Intent(ZadInf1.this, ZadInf2.class);
                        // startActivity(intent);
                        break;
                    case R.id.bottomTeoryK1:
                        Intent intent = new Intent(ZadInf1.this, ThInf1.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}
