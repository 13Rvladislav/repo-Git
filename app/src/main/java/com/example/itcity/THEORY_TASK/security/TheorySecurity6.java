package com.example.itcity.THEORY_TASK.security;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class TheorySecurity6 extends AppCompatActivity {
    Button next;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectheory6);
        getSupportActionBar().hide();
        next = findViewById(R.id.continieSec6);
        back=findViewById(R.id.bottomSecurityK);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec6:
                        Intent intent1 = new Intent(TheorySecurity6.this, Zadsec6.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomSecurityK:
                        Intent intent2 = new Intent(TheorySecurity6.this, Security_HOME.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}
