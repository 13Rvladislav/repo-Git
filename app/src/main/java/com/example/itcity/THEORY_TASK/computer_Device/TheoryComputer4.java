package com.example.itcity.THEORY_TASK.computer_Device;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.itcity.R;

public class TheoryComputer4 extends AppCompatActivity {

    Button continieCompDev;
    Button bottomCompDevK4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtheory4);

        getSupportActionBar().hide();

        continieCompDev = (Button) findViewById(R.id.continieCompDev);
        bottomCompDevK4 = (Button) findViewById(R.id.bottomCompDevK4);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continueSec:
                        Intent intent1 = new Intent(TheoryComputer4.this, ZadanieComputer4.class);
                        startActivity(intent1);
                        break;
                    case R.id.bottomCompDevK4:
                        Intent intent2 = new Intent(TheoryComputer4.this, Computer_Teory_Task.class);
                        startActivity(intent2);
                        break;


                }
            }
        };
        continieCompDev.setOnClickListener(onClickListener);
        bottomCompDevK4.setOnClickListener(onClickListener);

    }
}