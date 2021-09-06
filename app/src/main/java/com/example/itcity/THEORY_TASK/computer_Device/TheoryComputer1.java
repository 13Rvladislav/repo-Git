package com.example.itcity.THEORY_TASK.computer_Device;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.itcity.R;

public class TheoryComputer1 extends AppCompatActivity {

    Button continieCompDev;
    Button bottomCompDevK1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtheory1);

        getSupportActionBar().hide();
        continieCompDev = (Button) findViewById(R.id.continieCompDev);
        bottomCompDevK1 = (Button) findViewById(R.id.bottomCompDevK1);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continueSec:
                        Intent intent1 = new Intent(TheoryComputer1.this, ZadanieComputer1.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomCompDevK1:
                        Intent intent2 = new Intent(TheoryComputer1.this, Computer_Teory_Task.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        continieCompDev.setOnClickListener(onClickListener);
        bottomCompDevK1.setOnClickListener(onClickListener);

    }
}