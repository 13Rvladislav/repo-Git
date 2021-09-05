package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class TheoryAlgorithm6 extends AppCompatActivity {
    Button bottomTeoryK6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtheory6);
        getSupportActionBar().hide();

        bottomTeoryK6 = (Button) findViewById(R.id.bottomTeoryK6);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    case R.id.bottomTeoryK6:
                        Intent intent2 = new Intent(TheoryAlgorithm6.this, Algorithm_HOME.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        bottomTeoryK6.setOnClickListener(onClickListener);
    }
}