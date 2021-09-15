package com.example.itcity.THEORY_TASK.computer_Device;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class Comp_Home extends AppCompatActivity {
    ImageButton BUTTON1;
    ImageButton BUTTON2;
    ImageButton BUTTON3;
    ImageButton BUTTON4;
    ImageButton BUTTON5;
    ImageButton BUTTON6;
    Button BACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer__teory__task);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана

        BUTTON1 = (ImageButton) findViewById(R.id.COMPBUTTON1);
        BUTTON2 = (ImageButton) findViewById(R.id.COMPBUTTON2);
        BUTTON3 = (ImageButton) findViewById(R.id.COMPBUTTON3);
        BUTTON4 = (ImageButton) findViewById(R.id.COMPBUTTON4);
        BUTTON5 = (ImageButton) findViewById(R.id.COMPBUTTON5);
        BUTTON6 = (ImageButton) findViewById(R.id.COMPBUTTON6);
        BACK = (Button) findViewById(R.id.COMPBUTTONBACK);


        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.COMPBUTTONBACK:
                        Intent intent0 = new Intent(Comp_Home.this, ActivityMap.class);
                        startActivity(intent0);
                        break;
                    case R.id.COMPBUTTON1:
                        Intent intent1 = new Intent(Comp_Home.this, TheoryComputer1.class);
                        startActivity(intent1);
                        break;
                    case R.id.COMPBUTTON2:
                        Intent intent2 = new Intent(Comp_Home.this, TheoryComputer2.class);
                        startActivity(intent2);
                        break;
                    case R.id.COMPBUTTON3:
                        Intent intent3 = new Intent(Comp_Home.this, TheoryComputer3.class);
                        startActivity(intent3);
                        break;
                    case R.id.COMPBUTTON4:
                        Intent intent4 = new Intent(Comp_Home.this, TheoryComputer4.class);
                        startActivity(intent4);
                        break;
                    case R.id.COMPBUTTON5:
                        Intent intent5 = new Intent(Comp_Home.this, TheoryComputer5.class);
                        startActivity(intent5);
                        break;
                    case R.id.COMPBUTTON6:
                        Intent intent6 = new Intent(Comp_Home.this, TheoryComputer6.class);
                        startActivity(intent6);
                        break;
                    default:
                        break;
                }
            }
        };

        BUTTON1.setOnClickListener(onClickListener);
        BUTTON2.setOnClickListener(onClickListener);
        BUTTON3.setOnClickListener(onClickListener);
        BUTTON4.setOnClickListener(onClickListener);
        BUTTON5.setOnClickListener(onClickListener);
        BUTTON6.setOnClickListener(onClickListener);
        BACK.setOnClickListener(onClickListener);
    }
}