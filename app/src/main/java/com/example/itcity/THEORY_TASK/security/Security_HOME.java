package com.example.itcity.THEORY_TASK.security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.itcity.R;

public class Security_HOME extends AppCompatActivity {
    ImageButton Secbutton1;
    ImageButton SECBUTTON2;
    ImageButton SECBUTTON3;
    ImageButton SECBUTTON4;
    ImageButton SECBUTTON5;
    ImageButton SECBUTTON6;
    ImageButton SECBUTTON7;
    ImageButton SECBUTTON8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security__teory__task);

        Secbutton1 = (ImageButton) findViewById(R.id.SECBUTTON1);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.SECBUTTON1:
                        Intent intent = new Intent(Security_HOME.this, TheorySecurity1.class);
                        startActivity(intent);
                        break;
                        /*
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
                         */
                }


            }
        };
        Secbutton1.setOnClickListener(onClickListener);
        /*
        SECBUTTON2.setOnClickListener(onClickListener);
        SECBUTTON3.setOnClickListener(onClickListener);
        SECBUTTON4.setOnClickListener(onClickListener);
        SECBUTTON5.setOnClickListener(onClickListener);
        SECBUTTON6.setOnClickListener(onClickListener);
        SECBUTTON7.setOnClickListener(onClickListener);
        SECBUTTON8.setOnClickListener(onClickListener);
        */

    }
}