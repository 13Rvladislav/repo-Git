package com.example.itcity.THEORY_TASK.security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.itcity.R;

public class Security_HOME extends AppCompatActivity {
    ImageButton Secbutton1;
    ImageButton Secbutton2;
    ImageButton Secbutton3;
    ImageButton Secbutton4;
    ImageButton Secbutton5;
    ImageButton Secbutton6;
    ImageButton Secbutton7;
    ImageButton Secbutton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security__teory__task);

        Secbutton1 = (ImageButton) findViewById(R.id.SECBUTTON1);
        Secbutton2 = (ImageButton) findViewById(R.id.SECBUTTON2);
        Secbutton3 = (ImageButton) findViewById(R.id.SECBUTTON3);
        Secbutton4 = (ImageButton) findViewById(R.id.SECBUTTON4);
        Secbutton5 = (ImageButton) findViewById(R.id.SECBUTTON5);
        Secbutton6 = (ImageButton) findViewById(R.id.SECBUTTON6);
        Secbutton7 = (ImageButton) findViewById(R.id.SECBUTTON7);
        Secbutton8 = (ImageButton) findViewById(R.id.SECBUTTON8);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.SECBUTTON1:
                        Intent intent = new Intent(Security_HOME.this, TheorySecurity1.class);
                        startActivity(intent);
                        break;

                    case R.id.SECBUTTON2:
                        Intent intent2 = new Intent(Security_HOME.this, TheorySecurity2.class);
                        startActivity(intent2);
                        break;
                    case R.id.SECBUTTON3:
                        Intent intent3 = new Intent(Security_HOME.this, TheorySecurity3.class);
                        startActivity(intent3);
                        break;
                    case R.id.SECBUTTON4:
                        Intent intent4 = new Intent(Security_HOME.this, TheorySecurity4.class);
                        startActivity(intent4);
                        break;
                    case R.id.SECBUTTON5:
                        Intent intent5 = new Intent(Security_HOME.this, TheorySecurity5.class);
                        startActivity(intent5);
                        break;
                    case R.id.SECBUTTON6:
                        Intent intent6 = new Intent(Security_HOME.this, TheorySecurity6.class);
                        startActivity(intent6);
                        break;
                    case R.id.SECBUTTON7:
                        Intent intent7 = new Intent(Security_HOME.this, TheorySecurity7.class);
                        startActivity(intent7);
                        break;
                    case R.id.SECBUTTON8:
                        Intent intent8 = new Intent(Security_HOME.this, TheorySecurity8.class);
                        startActivity(intent8);
                        break;

                    default:
                        break;

                }


            }
        };
        Secbutton1.setOnClickListener(onClickListener);
        Secbutton2.setOnClickListener(onClickListener);
        Secbutton3.setOnClickListener(onClickListener);
        Secbutton4.setOnClickListener(onClickListener);
        Secbutton5.setOnClickListener(onClickListener);
        Secbutton6.setOnClickListener(onClickListener);
        Secbutton7.setOnClickListener(onClickListener);
        Secbutton8.setOnClickListener(onClickListener);


    }
}