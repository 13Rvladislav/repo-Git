package com.example.itcity.THEORY_TASK.computer_Device;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class Computer_Home extends AppCompatActivity {
    ImageButton COMPBUTTON1;
    ImageButton COMPBUTTON2;
    ImageButton COMPBUTTON3;
    ImageButton COMPBUTTON4;
    ImageButton COMPBUTTON5;
    ImageButton COMPBUTTON6;
    ImageButton COMPBUTTON7;
    ImageButton COMPBUTTON8;
    ImageButton COMPBUTTON9;
    Button COMPBUTTONBACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer__teory__task);


        COMPBUTTON1 = (ImageButton) findViewById(R.id.COMPBUTTON1);
        COMPBUTTON2 = (ImageButton) findViewById(R.id.COMPBUTTON2);
        COMPBUTTON3 = (ImageButton) findViewById(R.id.COMPBUTTON3);
        COMPBUTTON4 = (ImageButton) findViewById(R.id.COMPBUTTON4);
        COMPBUTTON5 = (ImageButton) findViewById(R.id.COMPBUTTON5);
        COMPBUTTON6 = (ImageButton) findViewById(R.id.COMPBUTTON6);
        COMPBUTTON7 = (ImageButton) findViewById(R.id.COMPBUTTON7);
        COMPBUTTON8 = (ImageButton) findViewById(R.id.COMPBUTTON8);
        COMPBUTTON9 = (ImageButton) findViewById(R.id.COMPBUTTON9);
        COMPBUTTONBACK = (Button) findViewById(R.id.COMPBUTTONBACK);


        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.COMPBUTTON1:
                        Intent intent1 = new Intent(Computer_Home.this, TheoryComputer1.class);
                        startActivity(intent1);
                        break;
                    case R.id.COMPBUTTON2:
                        Intent intent2 = new Intent(Computer_Home.this, TheoryComputer2.class);
                        startActivity(intent2);
                        break;
                    case R.id.COMPBUTTON3:
                        Intent intent3 = new Intent(Computer_Home.this, TheoryComputer3.class);
                        startActivity(intent3);
                        break;
                    case R.id.COMPBUTTON4:
                        Intent intent4 = new Intent(Computer_Home.this, TheoryComputer4.class);
                        startActivity(intent4);
                        break;
                    case R.id.COMPBUTTON5:
                        Intent intent5 = new Intent(Computer_Home.this, TheoryComputer5.class);
                        startActivity(intent5);
                        break;
                    case R.id.COMPBUTTONBACK:
                        Intent intent6 = new Intent(Computer_Home.this, ActivityMap.class);
                        startActivity(intent6);
                        break;

                    default:
                        break;
                }
            }
        };

        COMPBUTTON1.setOnClickListener(onClickListener);
        COMPBUTTON2.setOnClickListener(onClickListener);
        COMPBUTTON3.setOnClickListener(onClickListener);
        COMPBUTTON4.setOnClickListener(onClickListener);
        COMPBUTTON5.setOnClickListener(onClickListener);
        COMPBUTTONBACK.setOnClickListener(onClickListener);



    }


}