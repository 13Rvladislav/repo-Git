package com.example.itcity.THEORY_TASK.security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheorySecurity4 extends AppCompatActivity {
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectheory4);
        next = findViewById(R.id.continieSec4);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec4:
                        Intent intent = new Intent(TheorySecurity4.this, ZadSec4.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        next.setOnClickListener(onClickListener);
    }
}
