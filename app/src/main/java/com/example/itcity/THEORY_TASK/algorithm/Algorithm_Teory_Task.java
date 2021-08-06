package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.itcity.ActivityAuthor;
import com.example.itcity.MainActivity;
import com.example.itcity.R;

public class Algorithm_Teory_Task extends AppCompatActivity {
   Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm__teory__task);
/*
        a = (Button) findViewById(R.id.HomeB1);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.HomeB1:
                        Intent intent = new Intent(Algorithm_Teory_Task.this, TheoryAlgorithm.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        };
        a.setOnClickListener(onClickListener);

    */
    }
}