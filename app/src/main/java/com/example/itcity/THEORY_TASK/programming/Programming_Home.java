package com.example.itcity.THEORY_TASK.programming;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;
import com.example.itcity.models.ProfileU;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Programming_Home extends AppCompatActivity {
    ImageButton BUTTON1;
    ImageButton BUTTON2;
    ImageButton BUTTON3;
    ImageButton BUTTON4;
    ImageButton BUTTON5;
    ImageButton BUTTON6;
    ImageButton BUTTON7;
    ImageButton BUTTON8;
    ImageButton BUTTON9;
    ImageButton BUTTON10;
    ImageButton BUTTON11;
    ImageButton BUTTON12;
    ImageButton BUTTON13;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ProfileU DB = new ProfileU();
    int access;
    ArrayList<ImageButton> ButtonList = new ArrayList<>(13);

    Button BACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.activity_programming__teory__task);
        BUTTON1 = (ImageButton) findViewById(R.id.PROGBUTTON1);
        BUTTON2 = (ImageButton) findViewById(R.id.PROGBUTTON2);
        BUTTON3 = (ImageButton) findViewById(R.id.PROGBUTTON3);
        BUTTON4 = (ImageButton) findViewById(R.id.PROGBUTTON4);
        BUTTON5 = (ImageButton) findViewById(R.id.PROGBUTTON5);
        BUTTON6 = (ImageButton) findViewById(R.id.PROGBUTTON6);
        BUTTON7 = (ImageButton) findViewById(R.id.PROGBUTTON7);
        BUTTON8 = (ImageButton) findViewById(R.id.PROGBUTTON8);
        BUTTON9 = (ImageButton) findViewById(R.id.PROGBUTTON9);
        BUTTON10 = (ImageButton) findViewById(R.id.PROGBUTTON10);
        BUTTON11 = (ImageButton) findViewById(R.id.PROGBUTTON11);
        BUTTON12 = (ImageButton) findViewById(R.id.PROGBUTTON12);
        BUTTON13 = (ImageButton) findViewById(R.id.PROGBUTTON13);
        BACK = findViewById(R.id.PROGBUTTONBACK);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        String UID = user1.getUid();

        ButtonList.add(BUTTON1);
        ButtonList.add(BUTTON2);
        ButtonList.add(BUTTON3);
        ButtonList.add(BUTTON4);
        ButtonList.add(BUTTON5);
        ButtonList.add(BUTTON6);
        ButtonList.add(BUTTON7);
        ButtonList.add(BUTTON8);
        ButtonList.add(BUTTON9);
        ButtonList.add(BUTTON10);
        ButtonList.add(BUTTON11);
        ButtonList.add(BUTTON12);
        ButtonList.add(BUTTON13);

        users.child(UID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DB = snapshot.getValue(ProfileU.class);
                access = DB.getProgramming();
                for (int j = 0; j <= access; j++) {
                    int i = j - 1;
                    if (j == 13) {
                        ButtonList.get(i - 12).setImageResource(R.drawable.progonhome1);
                        ButtonList.get(i - 11).setImageResource(R.drawable.progonhome2);
                        ButtonList.get(i - 10).setImageResource(R.drawable.progonhome3);
                        ButtonList.get(i - 9).setImageResource(R.drawable.progonhome4);
                        ButtonList.get(i - 8).setImageResource(R.drawable.progonhome5);
                        ButtonList.get(i - 7).setImageResource(R.drawable.progonhome6);
                        ButtonList.get(i - 6).setImageResource(R.drawable.progonhome7);
                        ButtonList.get(i - 5).setImageResource(R.drawable.progonhome8);
                        ButtonList.get(i - 4).setImageResource(R.drawable.progonhome9);
                        ButtonList.get(i - 3).setImageResource(R.drawable.progonhome10);
                        ButtonList.get(i - 2).setImageResource(R.drawable.progonhome11);
                        ButtonList.get(i - 1).setImageResource(R.drawable.progonhome12);
                        ButtonList.get(i).setImageResource(R.drawable.progonhome13);
                    }
                    i = j;
                    if (i > access) {
                        ButtonList.get(i).setEnabled(false);
                    }
                    if (i == access) {
                        switch (i) {
                            case 1:
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome2);
                                break;
                            case 2:
                                ButtonList.get(i - 2).setImageResource(R.drawable.infonhome1);
                                ButtonList.get(i - 1).setImageResource(R.drawable.infonhome2);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome3);
                                break;
                            case 3:
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome4);
                                break;
                            case 4:
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome5);
                                break;
                            case 5:
                                ButtonList.get(i - 5).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome5);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome6);
                                break;
                            case 6:
                                ButtonList.get(i - 6).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 5).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome5);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome6);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome7);
                                break;
                            case 7:
                                ButtonList.get(i - 7).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 6).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 5).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome5);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome6);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome7);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome8);
                                break;
                            case 8:
                                ButtonList.get(i - 8).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 7).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 6).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 5).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome5);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome6);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome7);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome8);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome9);
                                break;
                            case 9:
                                ButtonList.get(i - 9).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 8).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 7).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 6).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i - 5).setImageResource(R.drawable.progonhome5);
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome6);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome7);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome8);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome9);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome10);
                                break;
                            case 10:
                                ButtonList.get(i - 10).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 9).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 8).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 7).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i - 6).setImageResource(R.drawable.progonhome5);
                                ButtonList.get(i - 5).setImageResource(R.drawable.progonhome6);
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome7);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome8);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome9);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome10);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome11);
                                break;
                            case 11:
                                ButtonList.get(i - 11).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 10).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 9).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 8).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i - 7).setImageResource(R.drawable.progonhome5);
                                ButtonList.get(i - 6).setImageResource(R.drawable.progonhome6);
                                ButtonList.get(i - 5).setImageResource(R.drawable.progonhome7);
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome8);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome9);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome10);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome11);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome12);
                                break;
                            case 12:
                                ButtonList.get(i - 12).setImageResource(R.drawable.progonhome1);
                                ButtonList.get(i - 11).setImageResource(R.drawable.progonhome2);
                                ButtonList.get(i - 10).setImageResource(R.drawable.progonhome3);
                                ButtonList.get(i - 9).setImageResource(R.drawable.progonhome4);
                                ButtonList.get(i - 8).setImageResource(R.drawable.progonhome5);
                                ButtonList.get(i - 7).setImageResource(R.drawable.progonhome6);
                                ButtonList.get(i - 6).setImageResource(R.drawable.progonhome7);
                                ButtonList.get(i - 5).setImageResource(R.drawable.progonhome8);
                                ButtonList.get(i - 4).setImageResource(R.drawable.progonhome9);
                                ButtonList.get(i - 3).setImageResource(R.drawable.progonhome10);
                                ButtonList.get(i - 2).setImageResource(R.drawable.progonhome11);
                                ButtonList.get(i - 1).setImageResource(R.drawable.progonhome12);
                                ButtonList.get(i).setImageResource(R.drawable.progoffhome13);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.PROGBUTTONBACK:
                        Intent intent0 = new Intent(Programming_Home.this, ActivityMap.class);
                        startActivity(intent0);
                        break;
                    case R.id.PROGBUTTON1:
                        Intent intent1 = new Intent(Programming_Home.this, Thprog1.class);
                        startActivity(intent1);
                        break;
                    case R.id.PROGBUTTON2:
                        Intent intent2 = new Intent(Programming_Home.this, Thpr2.class);
                        startActivity(intent2);
                        break;
                    case R.id.PROGBUTTON3:
                        Intent intent3 = new Intent(Programming_Home.this, Thpr3.class);
                        startActivity(intent3);
                        break;
                    case R.id.PROGBUTTON4:
                        Intent intent4 = new Intent(Programming_Home.this, Thpr4.class);
                        startActivity(intent4);
                        break;
                    case R.id.PROGBUTTON5:
                        Intent intent5 = new Intent(Programming_Home.this, Thpr5.class);
                        startActivity(intent5);
                        break;
                    case R.id.PROGBUTTON6:
                        Intent intent6 = new Intent(Programming_Home.this, Thpr6.class);
                        startActivity(intent6);
                        break;
                    case R.id.PROGBUTTON7:
                        Intent intent7 = new Intent(Programming_Home.this, Thpr7.class);
                        startActivity(intent7);
                        break;
                    case R.id.PROGBUTTON8:
                        Intent intent8 = new Intent(Programming_Home.this, Thpr8.class);
                        startActivity(intent8);
                        break;
                    case R.id.PROGBUTTON9:
                        Intent intent9 = new Intent(Programming_Home.this, Thpr9.class);
                        startActivity(intent9);
                        break;
                    case R.id.PROGBUTTON10:
                        Intent intent10 = new Intent(Programming_Home.this, Thpr10.class);
                        startActivity(intent10);
                        break;
                    case R.id.PROGBUTTON11:
                        Intent intent11 = new Intent(Programming_Home.this, Thpr11.class);
                        startActivity(intent11);
                        break;
                    case R.id.PROGBUTTON12:
                        Intent intent12 = new Intent(Programming_Home.this, Thpr12.class);
                        startActivity(intent12);
                        break;
                    case R.id.PROGBUTTON13:
                        Intent intent13 = new Intent(Programming_Home.this, Thpr13.class);
                        startActivity(intent13);
                        break;


                    default:
                        break;
                }
            }
        };

        BUTTON1.setOnClickListener(onClickListener);
        BUTTON2.setOnClickListener(onClickListener);
        BUTTON3.setOnClickListener(onClickListener);
        BUTTON4.setOnClickListener(onClickListener);
        BUTTON5.setOnClickListener(onClickListener);
        BUTTON6.setOnClickListener(onClickListener);
        BUTTON7.setOnClickListener(onClickListener);
        BUTTON8.setOnClickListener(onClickListener);
        BUTTON9.setOnClickListener(onClickListener);
        BUTTON10.setOnClickListener(onClickListener);
        BUTTON11.setOnClickListener(onClickListener);
        BUTTON12.setOnClickListener(onClickListener);
        BUTTON13.setOnClickListener(onClickListener);

        BACK.setOnClickListener(onClickListener);
    }
}
