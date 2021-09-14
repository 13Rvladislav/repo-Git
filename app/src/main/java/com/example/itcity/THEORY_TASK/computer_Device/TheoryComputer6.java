package com.example.itcity.THEORY_TASK.computer_Device;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheoryComputer6 extends AppCompatActivity {
    Button next;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtheory6);
        getSupportActionBar().hide();

        next = (Button) findViewById(R.id.continieCompDev);
        back = (Button) findViewById(R.id.bottomCompDevK1);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieCompDev:
                        Intent intent1 = new Intent(TheoryComputer6.this,Zadcomp6.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomCompDevK1:
                        Intent intent2 = new Intent(TheoryComputer6.this, Comp_Home.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}