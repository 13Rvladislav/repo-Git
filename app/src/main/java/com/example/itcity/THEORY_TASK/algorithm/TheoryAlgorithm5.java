package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.R;

public class TheoryAlgorithm5 extends AppCompatActivity {
   Button button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtheory5);
        getSupportActionBar().hide();
        button7 = (Button) findViewById(R.id.button7);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button7:
                        Intent intent1 = new Intent(TheoryAlgorithm5.this, ZadanieAlgorithm5.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        button7.setOnClickListener(onClickListener);
    }
}
