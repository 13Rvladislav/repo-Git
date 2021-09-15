package com.example.itcity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.THEORY_TASK.algorithm.Algorithm_HOME;
import com.example.itcity.THEORY_TASK.computer_Device.Comp_Home;
import com.example.itcity.THEORY_TASK.fundamental_of_informatics.Informatica_HOME;
import com.example.itcity.THEORY_TASK.programming.Programming_Teory_Task;
import com.example.itcity.THEORY_TASK.security.Security_HOME;

public class ActivityMap extends AppCompatActivity {
    private Button buttonAlgoritm;
    private Button buttonSeccure;
    private Button buttonProgramming;
    private Button buttonInformatica;
    private Button buttonPC;
    private Button buttonRait;
    private Button profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        buttonAlgoritm = (Button) findViewById(R.id.buttonAlgorithms);
        buttonSeccure = (Button) findViewById(R.id.buttonSecure);
        buttonProgramming = (Button) findViewById(R.id.buttonProgramming);
        buttonInformatica = (Button) findViewById(R.id.buttonInforatica);
        buttonPC = (Button) findViewById(R.id.buttonComputer);
        buttonRait = (Button) findViewById(R.id.buttonRait);
        profile = (Button) findViewById(R.id.profile);
        getSupportActionBar().hide();


        View.OnClickListener onClickListener = new View.OnClickListener() {




            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonAlgorithms:
                        Intent intent1 = new Intent(ActivityMap.this, Algorithm_HOME.class);
                        startActivity(intent1);
                        break;
                    case R.id.buttonSecure:
                        Intent intent2 = new Intent(ActivityMap.this, Security_HOME.class);
                        startActivity(intent2);
                        break;
                    case R.id.buttonProgramming:
                        Intent intent3 = new Intent(ActivityMap.this, Programming_Teory_Task.class);
                        startActivity(intent3);
                        break;
                    case R.id.buttonInforatica:
                        Intent intent4 = new Intent(ActivityMap.this, Informatica_HOME.class);
                        startActivity(intent4);
                        break;
                    case R.id.buttonComputer:
                        Intent intent5 = new Intent(ActivityMap.this, Comp_Home.class);
                        startActivity(intent5);
                        break;
                    case R.id.buttonRait:
                        Intent intent6 = new Intent(ActivityMap.this, ActivityAuthor.class);
                        startActivity(intent6);
                        break;
                    case R.id.profile:
                        Intent intent7 = new Intent(ActivityMap.this, Activity_Profile.class);
                        startActivity(intent7);

                    default:
                        break;
                }
            }
        };

        buttonAlgoritm.setOnClickListener(onClickListener);
        buttonSeccure.setOnClickListener(onClickListener);
        buttonProgramming.setOnClickListener(onClickListener);
        buttonInformatica.setOnClickListener(onClickListener);
        buttonPC.setOnClickListener(onClickListener);
        buttonRait.setOnClickListener(onClickListener);
        profile.setOnClickListener(onClickListener);
    }


}
