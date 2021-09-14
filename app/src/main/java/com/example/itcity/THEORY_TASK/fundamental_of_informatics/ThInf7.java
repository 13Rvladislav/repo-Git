package com.example.itcity.THEORY_TASK.fundamental_of_informatics;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.itcity.R;

public class ThInf7 extends AppCompatActivity {
    Button button8;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.inftheory7);
        button8=findViewById(R.id.button8);
        back=findViewById(R.id.bottomTeoryK1);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomTeoryK1:
                        Intent intent1 = new Intent(ThInf7.this,Informatica_HOME.class);
                        startActivity(intent1);
                        break;
                    case R.id.button8:
                        Intent intent = new Intent(ThInf7.this,ZadInf7.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        button8.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}