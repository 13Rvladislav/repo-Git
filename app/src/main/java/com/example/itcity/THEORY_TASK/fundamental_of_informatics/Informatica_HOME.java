package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import android.content.Intent;
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
    Button INFBUTTONBACK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatica__teory__task);
        INFBUTTON1 = (ImageButton) findViewById(R.id.SECBUTTON1);
        INFBUTTON2 = (ImageButton) findViewById(R.id.SECBUTTON2);
        INFBUTTON3 = (ImageButton) findViewById(R.id.SECBUTTON3);
        INFBUTTON4 = (ImageButton) findViewById(R.id.SECBUTTON4);
        INFBUTTON5 = (ImageButton) findViewById(R.id.SECBUTTON5);
        INFBUTTON6 = (ImageButton) findViewById(R.id.SECBUTTON6);
        INFBUTTON7 = (ImageButton) findViewById(R.id.SECBUTTON7);
        INFBUTTON8 = (ImageButton) findViewById(R.id.SECBUTTON8);
        INFBUTTON9 = (ImageButton) findViewById(R.id.SECBUTTON9);
        //   home10=findViewById(R.id);
        //  home11=findViewById(R.id);
        //  home12=findViewById(R.id);
        //  home13=findViewById(R.id);
        //  home14=findViewById(R.id);
        // home15=findViewById(R.id);
        //  home16=findViewById(R.id);
        //home17=findViewById(R.id);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
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
                        Intent intent6 = new Intent(Informatica_HOME.this, TheoInf6.class);
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

                    case R.id.COMPBUTTONBACK:
                        Intent intent10 = new Intent(Informatica_HOME.this, ActivityMap.class);
                        startActivity(intent10);
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
        // COMPBUTTONBACK.setOnClickListener(onClickListener);


    }


}
