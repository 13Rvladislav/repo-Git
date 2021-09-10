package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class ThInf1 extends AppCompatActivity {
    Button button8;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.inftheory1);
        button8 = findViewById(R.id.button8);
        back = findViewById(R.id.bottomTeoryK1);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button8:
                        Intent intent1 = new Intent(ThInf1.this, ZadInf1.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomTeoryK1:
                        Intent intent2 = new Intent(ThInf1.this, Informatica_HOME.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        button8.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}