package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.itcity.R;

public class ThInf2 extends AppCompatActivity {
    Button button8;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.inftheory2);
        button8=findViewById(R.id.button8);
        back=findViewById(R.id.bottomCompDevK2);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button8:
                        Intent intent1 = new Intent(ThInf2.this,ZadInf2.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomCompDevK2:
                        Intent intent2 = new Intent(ThInf2.this,Informatica_HOME.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        button8.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}