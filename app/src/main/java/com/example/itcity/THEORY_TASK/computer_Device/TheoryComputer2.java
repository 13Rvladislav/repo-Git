package com.example.itcity.THEORY_TASK.computer_Device;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.itcity.R;
import com.example.itcity.THEORY_TASK.computer_Device.ZadanieComputer1;

public class TheoryComputer2 extends AppCompatActivity {
    Button continieCompDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.comtheory2);
        getSupportActionBar().hide();
        continieCompDev = (Button) findViewById(R.id.continieCompDev);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec:
                        Intent intent1 = new Intent(TheoryComputer2.this, ZadanieComputer2.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        continieCompDev.setOnClickListener(onClickListener);
    }
}
