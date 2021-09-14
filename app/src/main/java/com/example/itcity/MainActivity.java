package com.example.itcity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import static androidx.browser.customtabs.CustomTabsIntent.NO_TITLE;


public class MainActivity extends AppCompatActivity {


    private Button a;
    private Animation b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
        a = (Button) findViewById(R.id.buttonstart);

        a = findViewById(R.id.buttonstart);

        b = AnimationUtils.loadAnimation(this, R.anim.mytrans);
        b.setDuration(600);



        a.startAnimation(b);

        //обработка клавиш кнопок
        View.OnClickListener onClickListener = new View.OnClickListener() {


            Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    a.startAnimation(b);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            };

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonstart:
                        Intent intent = new Intent(MainActivity.this, ActivityAuthor.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        };

        a.setOnClickListener(onClickListener);


    }


}

