package com.example.itcity.THEORY_TASK.programming;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class Thpr3 extends AppCompatActivity {

    Button continueSec;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progtheory3);
        getSupportActionBar().hide();
        continueSec = (Button) findViewById(R.id.continueSec);
        back = (Button) findViewById(R.id.bottomSecurityK);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomSecurityK:
                    Intent intent2 = new Intent(Thpr3.this, Programming_Teory_Task.class);
                    startActivity(intent2);
                    break;
                    case R.id.continueSec:
                        Intent intent1 = new Intent(Thpr3.this, Zadprog3.class);
                        startActivity(intent1);
                        break;
                }
            }
        };
        continueSec.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}