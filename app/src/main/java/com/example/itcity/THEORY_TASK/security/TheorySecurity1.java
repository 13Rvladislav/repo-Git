package com.example.itcity.THEORY_TASK.security;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.itcity.R;

public class TheorySecurity1 extends AppCompatActivity {
    Button continieSec;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.sectheory1);
            getSupportActionBar().hide();
            continieSec = (Button) findViewById(R.id.continieSec);
            View.OnClickListener onClickListener = new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.continieSec:
                            Intent intent1 = new Intent(TheorySecurity1.this, ZadanieSecurity1.class);
                            startActivity(intent1);
                            break;


                    }
                }
            };
            continieSec.setOnClickListener(onClickListener);
        }
    }
