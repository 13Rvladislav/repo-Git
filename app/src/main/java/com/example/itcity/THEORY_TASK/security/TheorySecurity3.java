package com.example.itcity.THEORY_TASK.security;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.itcity.R;

public class TheorySecurity3 extends AppCompatActivity {
    Button continieSec3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sectheory3);
        getSupportActionBar().hide();
        continieSec3 = (Button) findViewById(R.id.continieSec3);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec3:
                        Intent intent1 = new Intent(TheorySecurity3.this, ZadanieSecurity3.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        continieSec3.setOnClickListener(onClickListener);
    }
}
