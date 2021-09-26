package com.example.itcity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.example.itcity.models.Users;
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
    TextView Textview;
String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        setContentView(R.layout.activity__profile);
        TextView UserName = findViewById(R.id.editTextTextPersonName);
        getSupportActionBar().hide();
        back = findViewById(R.id.button2);
        Exit = findViewById(R.id.button3);
        auth = FirebaseAuth.getInstance();
        Textview = findViewById(R.id.editTextTextPersonName);

        FirebaseUser user1 = auth.getCurrentUser();

        DB = FirebaseDatabase.getInstance();
        DatabaseReference reference = DB.getReference("Users");


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

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String UID = user1.getUid();
                for (DataSnapshot u : dataSnapshot.getChildren()) {

                    a = u.toString();
                    //  Textview.append(u.getValue(Users.class).toString() + '\n');
                    Textview.setText("");

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
