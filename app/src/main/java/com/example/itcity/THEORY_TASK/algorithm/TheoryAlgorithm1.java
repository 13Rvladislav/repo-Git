package com.example.itcity.THEORY_TASK.algorithm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;
import com.example.itcity.Utlis.Test;


public class TheoryAlgorithm1 extends AppCompatActivity {


    private TextView textView4;
    private TextView textView19;
    private TextView textView20;
    private TextView textView21;
    private TextView textView22;
    private TextView textView23;
    private TextView textView24;
    private TextView textView25;
    private TextView textView26;
    Button button11111111;
    Button button8;
    TextView textView5;
    Button bottomTeoryK1;
    private TextView mTextView;
    private String s = "\t\t\tЗдравствуй! Сегодня ты начнешь изучать раздел “Алгоритмы ”. Алгоритмом называется последовательность действий, направленных на решение поставленной задачи";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.algtheory1);
        getSupportActionBar().hide();
        textView5 = (TextView) findViewById(R.id.textView5);
        button8 = (Button) findViewById(R.id.button8);
        bottomTeoryK1 = (Button) findViewById(R.id.bottomTeoryK1);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView20 = (TextView) findViewById(R.id.textView20);
        textView21 = (TextView) findViewById(R.id.textView21);
        textView22 = (TextView) findViewById(R.id.textView22);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView24 = (TextView) findViewById(R.id.textView24);
        textView25 = (TextView) findViewById(R.id.textView25);
        textView26 = (TextView) findViewById(R.id.textView26);



        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button8:
                        Intent intent1 = new Intent(TheoryAlgorithm1.this, ZadanieAlgorithm1.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomTeoryK1:
                        Intent intent2 = new Intent(TheoryAlgorithm1.this, Algorithm_HOME.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        button8.setOnClickListener(onClickListener);
        bottomTeoryK1.setOnClickListener(onClickListener);
        button11111111.setOnClickListener(onClickListener);
    }
}