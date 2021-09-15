package com.example.itcity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Activity_Profile extends AppCompatActivity {
    Button back;
    Button Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.activity__profile);
        getSupportActionBar().hide();
        back = findViewById(R.id.button2);
        Exit = findViewById(R.id.button3);
        View.OnClickListener onClickListener = new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button2:
                        //кнопка назад
                        Intent intent1 = new Intent(Activity_Profile.this, ActivityMap.class);
                        startActivity(intent1);
                        break;
                    case R.id.button3:
                        //кнопка выхода
                         FirebaseAuth.getInstance().signOut();
                        Intent intent2 = new Intent(Activity_Profile.this, ActivityAuthor.class);
                        startActivity(intent2);
                        break;
                    default:
                        break;
                }
            }
        };

        back.setOnClickListener(onClickListener);
        Exit.setOnClickListener(onClickListener);


    }
}