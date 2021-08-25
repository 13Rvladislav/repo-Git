package com.example.itcity.THEORY_TASK.security;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.itcity.R;

public class TheorySecurity4 extends AppCompatActivity {
    Button continieSec4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sectheory4);
        getSupportActionBar().hide();
        continieSec4 = (Button) findViewById(R.id.continieSec4);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.continieSec4:
                        Intent intent1 = new Intent(TheorySecurity4.this, ZadanieSecurity4.class);
                        startActivity(intent1);
                        break;


                }
            }
        };
        continieSec4.setOnClickListener(onClickListener);
    }
}