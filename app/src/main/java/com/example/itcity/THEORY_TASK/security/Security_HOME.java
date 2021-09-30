package com.example.itcity.THEORY_TASK.security;

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

public class Security_HOME extends AppCompatActivity {
    FirebaseAuth authsec;
    FirebaseDatabase dbsec;
    DatabaseReference userssec;
    ProfileU securityDB = new ProfileU();
    int access;
    ArrayList<ImageButton> ButtonList = new ArrayList<>(8);
    Boolean go = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security__teory__task);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана

        authsec = FirebaseAuth.getInstance();
        FirebaseUser user1sec = authsec.getCurrentUser();
        dbsec = FirebaseDatabase.getInstance();
        userssec = dbsec.getReference("Users");
        String UID = user1sec.getUid();

        ImageButton Secbutton1 = findViewById(R.id.SECBUTTON1);
        ImageButton Secbutton2 = findViewById(R.id.SECBUTTON2);
        ImageButton Secbutton3 = findViewById(R.id.SECBUTTON3);
        ImageButton Secbutton4 = findViewById(R.id.SECBUTTON4);
        ImageButton Secbutton5 = findViewById(R.id.SECBUTTON5);
        ImageButton Secbutton6 = findViewById(R.id.SECBUTTON6);
        ImageButton Secbutton7 = findViewById(R.id.SECBUTTON7);
        ImageButton Secbutton8 = findViewById(R.id.SECBUTTON8);
        ButtonList.add(Secbutton1);
        ButtonList.add(Secbutton2);
        ButtonList.add(Secbutton3);
        ButtonList.add(Secbutton4);
        ButtonList.add(Secbutton5);
        ButtonList.add(Secbutton6);
        ButtonList.add(Secbutton7);
        ButtonList.add(Secbutton8);

        userssec.child(UID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                securityDB = snapshot.getValue(ProfileU.class);
                access = securityDB.getSecurity();
                if (6 == access) {
                    ButtonList.get(0).setImageResource(R.drawable.algonhome1);
                    ButtonList.get(1).setImageResource(R.drawable.algonhome2);
                    ButtonList.get(2).setImageResource(R.drawable.algonhome3);
                    ButtonList.get(3).setImageResource(R.drawable.algonhome4);
                    ButtonList.get(4).setImageResource(R.drawable.algonhome5);
                    ButtonList.get(5).setImageResource(R.drawable.algonhome6);
                    go = false;
                }
                if (go) {
                    for (int i = 0; i < ButtonList.size(); i++) {
                        if (i > access) {
                            ButtonList.get(i).setEnabled(false);
                        }
                        if (i == access) {
                            switch (i) {
                                case 1:
                                    ButtonList.get(i - 1).setImageResource(R.drawable.seconhome1);
                                    ButtonList.get(i).setImageResource(R.drawable.secoffhome2);
                                    break;
                                case 2:
                                    ButtonList.get(i - 2).setImageResource(R.drawable.seconhome1);
                                    ButtonList.get(i - 1).setImageResource(R.drawable.seconhome2);
                                    ButtonList.get(i).setImageResource(R.drawable.secoffhome3);
                                    break;
                                case 3:
                                    ButtonList.get(i - 3).setImageResource(R.drawable.seconhome1);
                                    ButtonList.get(i - 2).setImageResource(R.drawable.seconhome2);
                                    ButtonList.get(i - 1).setImageResource(R.drawable.seconhome3);
                                    ButtonList.get(i).setImageResource(R.drawable.secoffhome4);
                                    break;
                                case 4:
                                    ButtonList.get(i - 4).setImageResource(R.drawable.seconhome1);
                                    ButtonList.get(i - 3).setImageResource(R.drawable.seconhome2);
                                    ButtonList.get(i - 2).setImageResource(R.drawable.seconhome3);
                                    ButtonList.get(i - 1).setImageResource(R.drawable.seconhome4);
                                    ButtonList.get(i).setImageResource(R.drawable.secoffhome5);
                                    break;
                                case 5:
                                    ButtonList.get(i - 5).setImageResource(R.drawable.seconhome1);
                                    ButtonList.get(i - 4).setImageResource(R.drawable.seconhome2);
                                    ButtonList.get(i - 3).setImageResource(R.drawable.seconhome3);
                                    ButtonList.get(i - 2).setImageResource(R.drawable.seconhome4);
                                    ButtonList.get(i - 1).setImageResource(R.drawable.seconhome5);
                                    ButtonList.get(i).setImageResource(R.drawable.secoffhome6);
                                    break;
                                case 6:
                                    ButtonList.get(i - 6).setImageResource(R.drawable.seconhome1);
                                    ButtonList.get(i - 5).setImageResource(R.drawable.seconhome2);
                                    ButtonList.get(i - 4).setImageResource(R.drawable.seconhome3);
                                    ButtonList.get(i - 3).setImageResource(R.drawable.seconhome4);
                                    ButtonList.get(i - 2).setImageResource(R.drawable.seconhome5);
                                    ButtonList.get(i - 1).setImageResource(R.drawable.seconhome6);
                                    ButtonList.get(i).setImageResource(R.drawable.secoffhome7);
                                    break;
                                case 7:
                                    ButtonList.get(i - 7).setImageResource(R.drawable.seconhome1);
                                    ButtonList.get(i - 6).setImageResource(R.drawable.seconhome2);
                                    ButtonList.get(i - 5).setImageResource(R.drawable.seconhome3);
                                    ButtonList.get(i - 4).setImageResource(R.drawable.seconhome4);
                                    ButtonList.get(i - 3).setImageResource(R.drawable.seconhome5);
                                    ButtonList.get(i - 2).setImageResource(R.drawable.seconhome6);
                                    ButtonList.get(i - 1).setImageResource(R.drawable.seconhome7);
                                    ButtonList.get(i).setImageResource(R.drawable.secoffhome8);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        Button back = findViewById(R.id.SECBUTTONBACK);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.SECBUTTONBACK:
                        Intent intent0 = new Intent(Security_HOME.this, ActivityMap.class);
                        startActivity(intent0);
                        break;

                    case R.id.SECBUTTON1:
                        Intent intent1 = new Intent(Security_HOME.this, TheorySecurity1.class);
                        startActivity(intent1);
                        break;

                    case R.id.SECBUTTON2:
                        Intent intent2 = new Intent(Security_HOME.this, TheorySecurity2.class);
                        startActivity(intent2);
                        break;

                    case R.id.SECBUTTON3:
                        Intent intent3 = new Intent(Security_HOME.this, TheorySecurity3.class);
                        startActivity(intent3);
                        break;

                    case R.id.SECBUTTON4:
                        Intent intent4 = new Intent(Security_HOME.this, TheorySecurity4.class);
                        startActivity(intent4);
                        break;

                    case R.id.SECBUTTON5:
                        Intent intent5 = new Intent(Security_HOME.this, TheorySecurity5.class);
                        startActivity(intent5);
                        break;

                    case R.id.SECBUTTON6:
                        Intent intent6 = new Intent(Security_HOME.this, TheorySecurity6.class);
                        startActivity(intent6);
                        break;

                    case R.id.SECBUTTON7:
                        Intent intent7 = new Intent(Security_HOME.this, TheorySecurity7.class);
                        startActivity(intent7);
                        break;

                    case R.id.SECBUTTON8:
                        Intent intent8 = new Intent(Security_HOME.this, TheorySecurity8.class);
                        startActivity(intent8);
                        break;

                    default:
                        break;

                }
            }
        };
        Secbutton1.setOnClickListener(onClickListener);
        Secbutton2.setOnClickListener(onClickListener);
        Secbutton3.setOnClickListener(onClickListener);
        Secbutton4.setOnClickListener(onClickListener);
        Secbutton5.setOnClickListener(onClickListener);
        Secbutton6.setOnClickListener(onClickListener);
        Secbutton7.setOnClickListener(onClickListener);
        Secbutton8.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}