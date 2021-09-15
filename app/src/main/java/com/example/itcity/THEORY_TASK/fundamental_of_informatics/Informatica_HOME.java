package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;


public class Informatica_HOME extends AppCompatActivity {

    ImageButton INFBUTTON1;
    ImageButton INFBUTTON2;
    ImageButton INFBUTTON3;
    ImageButton INFBUTTON4;
    ImageButton INFBUTTON5;
    ImageButton INFBUTTON6;
    ImageButton INFBUTTON7;
    ImageButton INFBUTTON8;
    ImageButton INFBUTTON9;
    ImageButton INFBUTTON10;
    ImageButton INFBUTTON11;
    ImageButton INFBUTTON12;
    ImageButton INFBUTTON13;
    ImageButton INFBUTTON14;
    ImageButton INFBUTTON15;
    ImageButton INFBUTTON16;


    Button BACK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatica__teory__task);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        INFBUTTON1 = (ImageButton) findViewById(R.id.SECBUTTON1);
        INFBUTTON2 = (ImageButton) findViewById(R.id.SECBUTTON2);
        INFBUTTON3 = (ImageButton) findViewById(R.id.SECBUTTON3);
        INFBUTTON4 = (ImageButton) findViewById(R.id.SECBUTTON4);
        INFBUTTON5 = (ImageButton) findViewById(R.id.SECBUTTON5);
        INFBUTTON6 = (ImageButton) findViewById(R.id.SECBUTTON6);
        INFBUTTON7 = (ImageButton) findViewById(R.id.SECBUTTON7);
        INFBUTTON8 = (ImageButton) findViewById(R.id.SECBUTTON8);
        INFBUTTON9 = (ImageButton) findViewById(R.id.SECBUTTON9);
        INFBUTTON10 = (ImageButton) findViewById(R.id.SECBUTTON10);
        INFBUTTON11 = (ImageButton) findViewById(R.id.SECBUTTON11);
        INFBUTTON12 = (ImageButton) findViewById(R.id.SECBUTTON12);
        INFBUTTON13 = (ImageButton) findViewById(R.id.SECBUTTON13);
        INFBUTTON14 = (ImageButton) findViewById(R.id.SECBUTTON14);
        INFBUTTON15 = (ImageButton) findViewById(R.id.SECBUTTON15);
        BACK = findViewById(R.id.SECBUTTONBACK);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.SECBUTTONBACK:
                        Intent intent0 = new Intent(Informatica_HOME.this, ActivityMap.class);
                        startActivity(intent0);
                        break;
                    case R.id.SECBUTTON1:
                        Intent intent1 = new Intent(Informatica_HOME.this, ThInf1.class);
                        startActivity(intent1);
                        break;
                    case R.id.SECBUTTON2:
                        Intent intent2 = new Intent(Informatica_HOME.this, ThInf2.class);
                        startActivity(intent2);
                        break;
                    case R.id.SECBUTTON3:
                        Intent intent3 = new Intent(Informatica_HOME.this, ThInf3.class);
                        startActivity(intent3);
                        break;
                    case R.id.SECBUTTON4:
                        Intent intent4 = new Intent(Informatica_HOME.this, Tinf4.class);
                        startActivity(intent4);
                        break;
                    case R.id.SECBUTTON5:
                        Intent intent5 = new Intent(Informatica_HOME.this, TheoInf5.class);
                        startActivity(intent5);
                        break;
                    case R.id.SECBUTTON6:
                        Intent intent6 = new Intent(Informatica_HOME.this, ThInf6.class);
                        startActivity(intent6);
                        break;
                    case R.id.SECBUTTON7:
                        Intent intent7 = new Intent(Informatica_HOME.this, ThInf7.class);
                        startActivity(intent7);
                        break;
                    case R.id.SECBUTTON8:
                        Intent intent8 = new Intent(Informatica_HOME.this, ThInf8.class);
                        startActivity(intent8);
                        break;
                    case R.id.SECBUTTON9:
                        Intent intent9 = new Intent(Informatica_HOME.this, ThInf9.class);
                        startActivity(intent9);
                        break;
                    case R.id.SECBUTTON10:
                        Intent intent10 = new Intent(Informatica_HOME.this, ThInf10.class);
                        startActivity(intent10);
                        break;
                    case R.id.SECBUTTON11:
                        Intent intent11 = new Intent(Informatica_HOME.this, ThInf11.class);
                        startActivity(intent11);
                        break;
                    case R.id.SECBUTTON12:
                        Intent intent12 = new Intent(Informatica_HOME.this, ThInf12.class);
                        startActivity(intent12);
                        break;
                    case R.id.SECBUTTON13:
                        Intent intent13 = new Intent(Informatica_HOME.this, ThInf13.class);
                        startActivity(intent13);
                        break;
                    case R.id.SECBUTTON14:
                        Intent intent14 = new Intent(Informatica_HOME.this, ThInf14.class);
                        startActivity(intent14);
                        break;
                    case R.id.SECBUTTON15:
                        Intent intent15 = new Intent(Informatica_HOME.this, ThInf15.class);
                        startActivity(intent15);
                        break;
                    case R.id.COMPBUTTONBACK:
                        Intent intent = new Intent(Informatica_HOME.this, ActivityMap.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        };

        INFBUTTON1.setOnClickListener(onClickListener);
        INFBUTTON2.setOnClickListener(onClickListener);
        INFBUTTON3.setOnClickListener(onClickListener);
        INFBUTTON4.setOnClickListener(onClickListener);
        INFBUTTON5.setOnClickListener(onClickListener);
        INFBUTTON6.setOnClickListener(onClickListener);
        INFBUTTON7.setOnClickListener(onClickListener);
        INFBUTTON8.setOnClickListener(onClickListener);
        INFBUTTON9.setOnClickListener(onClickListener);
        INFBUTTON10.setOnClickListener(onClickListener);
        INFBUTTON11.setOnClickListener(onClickListener);
        INFBUTTON12.setOnClickListener(onClickListener);
        INFBUTTON13.setOnClickListener(onClickListener);
        INFBUTTON14.setOnClickListener(onClickListener);
        INFBUTTON15.setOnClickListener(onClickListener);
        BACK.setOnClickListener(onClickListener);


    }


}
