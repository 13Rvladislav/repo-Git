package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.itcity.ActivityAuthor;
import com.example.itcity.MainActivity;
import com.example.itcity.R;

public class Algorithm_HOME extends AppCompatActivity {
    ImageButton AlgButton1;
    ImageButton AlgButton2;
    ImageButton AlgButton3;
    ImageButton AlgButton4;
    ImageButton AlgButton5;
    ImageButton AlgButton6;
    ImageButton AlgButton7;
    ImageButton AlgButton8;
    ImageButton AlgButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm__teory__task);

        AlgButton1 = (ImageButton) findViewById(R.id.AlgButton1);
        AlgButton2 = (ImageButton) findViewById(R.id.AlgButton2);
        AlgButton3 = (ImageButton) findViewById(R.id.AlgButton3);
        AlgButton4 = (ImageButton) findViewById(R.id.AlgButton4);
        AlgButton5 = (ImageButton) findViewById(R.id.AlgButton5);
        AlgButton6 = (ImageButton) findViewById(R.id.AlgButton6);
        AlgButton7 = (ImageButton) findViewById(R.id.AlgButton7);
        AlgButton8 = (ImageButton) findViewById(R.id.AlgButton8);
        AlgButton9 = (ImageButton) findViewById(R.id.AlgButton9);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.AlgButton1:
                        Intent intent1 = new Intent(Algorithm_HOME.this, TheoryAlgorithm1.class);
                        startActivity(intent1);
                        break;
                    case R.id.AlgButton2:
                        Intent intent2 = new Intent(Algorithm_HOME.this, TheoryAlgorithm2.class);
                        startActivity(intent2);
                        break;
                    case R.id.AlgButton3:
                        Intent intent3 = new Intent(Algorithm_HOME.this, TheoryAlgorithm3.class);
                        startActivity(intent3);
                        break;
                    case R.id.AlgButton4:
                        Intent intent4 = new Intent(Algorithm_HOME.this, TheoryAlgorithm4.class);
                        startActivity(intent4);
                        break;
                    case R.id.AlgButton5:
                        Intent intent5 = new Intent(Algorithm_HOME.this, TheoryAlgorithm5.class);
                        startActivity(intent5);
                        break;
                    case R.id.AlgButton6:
                        Intent intent6 = new Intent(Algorithm_HOME.this, TheoryAlgorithm6.class);
                        startActivity(intent6);
                        break;
                    case R.id.AlgButton7:
                        Intent intent7 = new Intent(Algorithm_HOME.this, TheoryAlgorithm7.class);
                        startActivity(intent7);
                        break;
                    case R.id.AlgButton8:
                        Intent intent8 = new Intent(Algorithm_HOME.this, TheoryAlgorithm8.class);
                        startActivity(intent8);
                        break;
                    case R.id.AlgButton9:
                        Intent intent9 = new Intent(Algorithm_HOME.this, TheoryAlgorithm9.class);
                        startActivity(intent9);
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
        AlgButton7.setOnClickListener(onClickListener);
        AlgButton8.setOnClickListener(onClickListener);
        AlgButton9.setOnClickListener(onClickListener);


    }
}