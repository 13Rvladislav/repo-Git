package com.example.itcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.itcity.models.ProfileU;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity_Profile extends AppCompatActivity {
    Button back;
    Button Exit;
    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;
    String str;
    ProfileU me = new ProfileU();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.activity__profile);
        TextView UserName = findViewById(R.id.editTextTextPersonName);
        TextView mmrcount = findViewById(R.id.mark_for_the_lvl);
        getSupportActionBar().hide();
        back = findViewById(R.id.button2);
        Exit = findViewById(R.id.button3);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");

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
        String UID = user1.getUid();
        users.child(UID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                me = snapshot.getValue(ProfileU.class);
                str = me.getName();
                UserName.setText(str);
                str = me.getMmr();
                mmrcount.setText(str);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}