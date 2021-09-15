package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.itcity.R;

public class ThInf10 extends AppCompatActivity {
    Button button8;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.inftheory10);
        button8=findViewById(R.id.button8);
        back = findViewById(R.id.bottomCompDevK2);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomCompDevK2:
                        Intent intent1 = new Intent(ThInf10.this,Informatica_HOME.class);
                        startActivity(intent1);
                        break;
                    case R.id.button8:
                        Intent intent = new Intent(ThInf10.this,ZadInf10.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        button8.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}