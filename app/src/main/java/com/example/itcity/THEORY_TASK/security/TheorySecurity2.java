package com.example.itcity.THEORY_TASK.security;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class TheorySecurity2 extends AppCompatActivity {
    Button continieSec2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sectheory2);
        getSupportActionBar().hide();
        continieSec2 = (Button) findViewById(R.id.continieSec2);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec2:
                        Intent intent1 = new Intent(TheorySecurity2.this, ZadanieSecurity2.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        continieSec2.setOnClickListener(onClickListener);
    }
}
