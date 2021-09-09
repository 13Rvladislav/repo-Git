package com.example.itcity.THEORY_TASK.security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheorySecurity4 extends AppCompatActivity {
    Button next;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectheory4);
        getSupportActionBar().hide();
        next = findViewById(R.id.continieSec4);
        back=findViewById(R.id.bottomSecurityK);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec4:
                        Intent intent1 = new Intent(TheorySecurity4.this, ZadSec4.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomSecurityK:
                        Intent intent2 = new Intent(TheorySecurity4.this, Security_HOME.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}
