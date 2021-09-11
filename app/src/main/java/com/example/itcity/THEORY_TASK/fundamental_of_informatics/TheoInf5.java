package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class TheoInf5 extends AppCompatActivity {
    Button next;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.inftheory5);
        next = findViewById(R.id.button8);
        back = findViewById(R.id.bottomTeoryK1);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomTeoryK1:
                        Intent intent1 = new Intent(TheoInf5.this, Informatica_HOME.class);
                        startActivity(intent1);
                        break;
                    case R.id.button8:
                        Intent intent2 = new Intent(TheoInf5.this, ZadInf5.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}