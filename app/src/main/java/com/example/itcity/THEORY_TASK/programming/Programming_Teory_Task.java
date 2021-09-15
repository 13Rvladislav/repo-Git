package com.example.itcity.THEORY_TASK.programming;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf1;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf10;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf11;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf12;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf13;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf2;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf3;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf6;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf7;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf8;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.ThInf9;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.TheoInf5;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.Tinf4;

public class Programming_Teory_Task extends AppCompatActivity {
    ImageButton BUTTON1;
    ImageButton BUTTON2;
    ImageButton BUTTON3;
    ImageButton BUTTON4;
    ImageButton BUTTON5;
    ImageButton BUTTON6;
    ImageButton BUTTON7;
    ImageButton BUTTON8;
    ImageButton BUTTON9;
    ImageButton BUTTON10;
    ImageButton BUTTON11;
    ImageButton BUTTON12;
    ImageButton BUTTON13;


    Button BACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.activity_programming__teory__task);
        BUTTON1 = (ImageButton) findViewById(R.id.PROGBUTTON1);
        BUTTON2 = (ImageButton) findViewById(R.id.PROGBUTTON2);
        BUTTON3 = (ImageButton) findViewById(R.id.PROGBUTTON3);
        BUTTON4 = (ImageButton) findViewById(R.id.PROGBUTTON4);
        BUTTON5 = (ImageButton) findViewById(R.id.PROGBUTTON5);
        BUTTON6 = (ImageButton) findViewById(R.id.PROGBUTTON6);
        BUTTON7 = (ImageButton) findViewById(R.id.PROGBUTTON7);
        BUTTON8 = (ImageButton) findViewById(R.id.PROGBUTTON8);
        BUTTON9 = (ImageButton) findViewById(R.id.PROGBUTTON9);
        BUTTON10 = (ImageButton) findViewById(R.id.PROGBUTTON10);
        BUTTON11 = (ImageButton) findViewById(R.id.PROGBUTTON11);
        BUTTON12 = (ImageButton) findViewById(R.id.PROGBUTTON12);
        BUTTON13 = (ImageButton) findViewById(R.id.PROGBUTTON13);


        BACK = findViewById(R.id.PROGBUTTONBACK);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.PROGBUTTONBACK:
                        Intent intent0 = new Intent(Programming_Teory_Task.this, ActivityMap.class);
                        startActivity(intent0);
                        break;
                    case R.id.PROGBUTTON1:
                        Intent intent1 = new Intent(Programming_Teory_Task.this, Thprog1.class);
                        startActivity(intent1);
                        break;
                    case R.id.PROGBUTTON2:
                        Intent intent2 = new Intent(Programming_Teory_Task.this, Thpr2.class);
                        startActivity(intent2);
                        break;
                    case R.id.PROGBUTTON3:
                        Intent intent3 = new Intent(Programming_Teory_Task.this, Thpr3.class);
                        startActivity(intent3);
                        break;
                    case R.id.PROGBUTTON4:
                        Intent intent4 = new Intent(Programming_Teory_Task.this, Thpr4.class);
                        startActivity(intent4);
                        break;
                    case R.id.PROGBUTTON5:
                        Intent intent5 = new Intent(Programming_Teory_Task.this, Thpr5.class);
                        startActivity(intent5);
                        break;
                    case R.id.PROGBUTTON6:
                        Intent intent6 = new Intent(Programming_Teory_Task.this, Thpr6.class);
                        startActivity(intent6);
                        break;
                    case R.id.PROGBUTTON7:
                        Intent intent7 = new Intent(Programming_Teory_Task.this, Thpr7.class);
                        startActivity(intent7);
                        break;
                    case R.id.PROGBUTTON8:
                        Intent intent8 = new Intent(Programming_Teory_Task.this, Thpr8.class);
                        startActivity(intent8);
                        break;
                    case R.id.PROGBUTTON9:
                        Intent intent9 = new Intent(Programming_Teory_Task.this, Thpr9.class);
                        startActivity(intent9);
                        break;
                    case R.id.PROGBUTTON10:
                        Intent intent10 = new Intent(Programming_Teory_Task.this, Thpr10.class);
                        startActivity(intent10);
                        break;
                    case R.id.PROGBUTTON11:
                        Intent intent11 = new Intent(Programming_Teory_Task.this, Thpr11.class);
                        startActivity(intent11);
                        break;
                    case R.id.PROGBUTTON12:
                        Intent intent12 = new Intent(Programming_Teory_Task.this, Thpr12.class);
                        startActivity(intent12);
                        break;
                    case R.id.PROGBUTTON13:
                        Intent intent13 = new Intent(Programming_Teory_Task.this, Thpr13.class);
                        startActivity(intent13);
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
        BUTTON7.setOnClickListener(onClickListener);
        BUTTON8.setOnClickListener(onClickListener);
        BUTTON9.setOnClickListener(onClickListener);
        BUTTON10.setOnClickListener(onClickListener);
        BUTTON11.setOnClickListener(onClickListener);
        BUTTON12.setOnClickListener(onClickListener);
        BUTTON13.setOnClickListener(onClickListener);

        BACK.setOnClickListener(onClickListener);
    }
}
