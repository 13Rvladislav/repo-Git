package com.example.itcity.THEORY_TASK.algorithm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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

public class Algorithm_HOME extends AppCompatActivity {
    ImageButton AlgButton1;
    ImageButton AlgButton2;
    ImageButton AlgButton3;
    ImageButton AlgButton4;
    ImageButton AlgButton5;
    ImageButton AlgButton6;
    Button BACK;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ProfileU DB = new ProfileU();
    int access;
    ArrayList<ImageButton> ButtonList = new ArrayList<>(6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.activity_algorithm__teory__task);
        getSupportActionBar().hide();
        AlgButton1 = (ImageButton) findViewById(R.id.ALGButton1);
        AlgButton2 = (ImageButton) findViewById(R.id.ALGButton2);
        AlgButton3 = (ImageButton) findViewById(R.id.ALGButton3);
        AlgButton4 = (ImageButton) findViewById(R.id.ALGButton4);
        AlgButton5 = (ImageButton) findViewById(R.id.ALGButton5);
        AlgButton6 = (ImageButton) findViewById(R.id.ALGButton6);
        BACK = (Button) findViewById(R.id.ALGBUTTONBACK);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        String UID = user1.getUid();

        ButtonList.add(AlgButton1);
        ButtonList.add(AlgButton2);
        ButtonList.add(AlgButton3);
        ButtonList.add(AlgButton4);
        ButtonList.add(AlgButton5);
        ButtonList.add(AlgButton6);

        users.child(UID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DB = snapshot.getValue(ProfileU.class);
                access = DB.getAlgorithm();
                for (int i = 0; i < ButtonList.size(); i++) {
                    if (i > access) {
                        ButtonList.get(i).setEnabled(false);
                    }
                    if (i == access) {
                        switch (i) {
                            case 1:
                                ButtonList.get(i-1).setImageResource(R.drawable.algonhome1);
                                ButtonList.get(i).setImageResource(R.drawable.algoffhome2);
                                break;
                            case 2:
                                ButtonList.get(i-2).setImageResource(R.drawable.algonhome1);
                                ButtonList.get(i-1).setImageResource(R.drawable.algonhome2);
                                ButtonList.get(i).setImageResource(R.drawable.algoffhome3);
                                break;
                            case 3:
                                ButtonList.get(i-3).setImageResource(R.drawable.algonhome1);
                                ButtonList.get(i-2).setImageResource(R.drawable.algonhome2);
                                ButtonList.get(i-1).setImageResource(R.drawable.algonhome3);
                                ButtonList.get(i).setImageResource(R.drawable.algoffhome4);
                                break;
                            case 4:
                                ButtonList.get(i-4).setImageResource(R.drawable.algonhome1);
                                ButtonList.get(i-3).setImageResource(R.drawable.algonhome2);
                                ButtonList.get(i-2).setImageResource(R.drawable.algonhome3);
                                ButtonList.get(i-1).setImageResource(R.drawable.algonhome4);
                                ButtonList.get(i).setImageResource(R.drawable.algoffhome5);
                                break;
                            case 5:
                                ButtonList.get(i-5).setImageResource(R.drawable.algonhome1);
                                ButtonList.get(i-4).setImageResource(R.drawable.algonhome2);
                                ButtonList.get(i-3).setImageResource(R.drawable.algonhome3);
                                ButtonList.get(i-2).setImageResource(R.drawable.algonhome4);
                                ButtonList.get(i-1).setImageResource(R.drawable.algonhome5);
                                ButtonList.get(i).setImageResource(R.drawable.algoffhome6);
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
                    case R.id.ALGButton1:
                        Intent intent1 = new Intent(Algorithm_HOME.this, TheoryAlgorithm1.class);
                        startActivity(intent1);
                        break;
                    case R.id.ALGButton2:
                        Intent intent2 = new Intent(Algorithm_HOME.this, TheoryAlgorithm2.class);
                        startActivity(intent2);
                        break;
                    case R.id.ALGButton3:
                        Intent intent3 = new Intent(Algorithm_HOME.this, TheoryAlgorithm3.class);
                        startActivity(intent3);
                        break;
                    case R.id.ALGButton4:
                        Intent intent4 = new Intent(Algorithm_HOME.this, TheoryAlgorithm4.class);
                        startActivity(intent4);
                        break;
                    case R.id.ALGButton5:
                        Intent intent5 = new Intent(Algorithm_HOME.this, TheoryAlgorithm5.class);
                        startActivity(intent5);
                        break;
                    case R.id.ALGButton6:
                        Intent intent6 = new Intent(Algorithm_HOME.this, TheoryAlgorithm6.class);
                        startActivity(intent6);
                        break;
                    case R.id.ALGBUTTONBACK:
                        Intent intent7 = new Intent(Algorithm_HOME.this, ActivityMap.class);
                        startActivity(intent7);
                        break;

                    default:
                        break;
                }
            }
        };
        AlgButton1.setOnClickListener(onClickListener);
        AlgButton2.setOnClickListener(onClickListener);
        AlgButton3.setOnClickListener(onClickListener);
        AlgButton4.setOnClickListener(onClickListener);
        AlgButton5.setOnClickListener(onClickListener);
        AlgButton6.setOnClickListener(onClickListener);
        BACK.setOnClickListener(onClickListener);
    }
}