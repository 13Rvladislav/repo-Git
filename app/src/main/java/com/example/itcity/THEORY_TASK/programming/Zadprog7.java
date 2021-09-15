package com.example.itcity.THEORY_TASK.programming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class Zadprog7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progtask7);
        getSupportActionBar().hide();


        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent1 = new Intent(Zadprog7.this, Thpr7.class);
                        startActivity(intent1);
                        break;
                    default:
                        break;
                }
            }
        };

    }
}