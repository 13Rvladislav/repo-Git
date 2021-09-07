package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.itcity.R;

public class TheoryInformatica12 extends AppCompatActivity {
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inftheory12);
        button8=findViewById(R.id.button8);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button8:
                        Intent intent = new Intent(TheoryInformatica12.this,ZadanieInformatica12.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        button8.setOnClickListener(onClickListener);
    }
}