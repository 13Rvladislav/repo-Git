package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.itcity.R;

public class Algorithm_HOME extends AppCompatActivity {
    ImageButton AlgButton1;
    ImageButton AlgButton2;
    ImageButton AlgButton3;
    ImageButton AlgButton4;
    ImageButton AlgButton5;
    ImageButton AlgButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm__teory__task);

        AlgButton1 = (ImageButton) findViewById(R.id.ALGButton1);
        AlgButton2 = (ImageButton) findViewById(R.id.ALGButton2);
        AlgButton3 = (ImageButton) findViewById(R.id.ALGButton3);
        AlgButton4 = (ImageButton) findViewById(R.id.ALGButton4);
        AlgButton5 = (ImageButton) findViewById(R.id.ALGButton5);
        AlgButton6 = (ImageButton) findViewById(R.id.ALGButton6);


        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.ALGButton1:
                        Intent intent1 = new Intent(Algorithm_HOME.this, TheoryAlgorithm1.class);
                        startActivity(intent1);
                        break;
                    case R.id.ALGButton2:
                        Intent intent2 = new Intent(Algorithm_HOME.this, TheoryAlgorithm2.class);
                        startActivity(intent2);
                        break;
                    case R.id.ALGButton3:
                        Intent intent3 = new Intent(Algorithm_HOME.this, TheoryAlgorithm3.class);
                        startActivity(intent3);
                        break;
                    case R.id.ALGButton4:
                        Intent intent4 = new Intent(Algorithm_HOME.this, TheoryAlgorithm4.class);
                        startActivity(intent4);
                        break;
                    case R.id.ALGButton5:
                        Intent intent5 = new Intent(Algorithm_HOME.this, TheoryAlgorithm5.class);
                        startActivity(intent5);
                        break;
                    case R.id.ALGButton6:
                        Intent intent6 = new Intent(Algorithm_HOME.this, TheoryAlgorithm6.class);
                        startActivity(intent6);
                        break;

                    default:
                        break;
                }
            }
        };
        AlgButton1.setOnClickListener(onClickListener);
        AlgButton2.setOnClickListener(onClickListener);
        AlgButton3.setOnClickListener(onClickListener);
        AlgButton4.setOnClickListener(onClickListener);
        AlgButton5.setOnClickListener(onClickListener);
        AlgButton6.setOnClickListener(onClickListener);
    }
}