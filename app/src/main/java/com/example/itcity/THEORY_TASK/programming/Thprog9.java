package com.example.itcity.THEORY_TASK.programming;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.itcity.R;

public class Thprog9 extends AppCompatActivity {

    Button continueSec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progtheory9);
        getSupportActionBar().hide();
        continueSec = (Button) findViewById(R.id.continueSec);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continueSec:
                        Intent intent1 = new Intent(Thprog9.this, Zadprog9.class);
                        startActivity(intent1);
                        break;
                }
            }
        };
        continueSec.setOnClickListener(onClickListener);

    }
}