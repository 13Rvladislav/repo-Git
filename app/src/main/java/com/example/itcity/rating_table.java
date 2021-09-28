package com.example.itcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.itcity.models.ProfileU;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class rating_table extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ProfileU DB = new ProfileU();
    String number = "1", name, ratingstr;
    int rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
        LinearLayout layout = findViewById(R.id.mmrtable);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        String UID = user1.getUid();

        users.orderByChild("mmr").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    DB = dataSnapshot.getValue(ProfileU.class);
                    name = DB.getName();
                    rating = DB.getMmr();
                    ratingstr = Integer.toString(rating);
                    TextView tabletext = new TextView(rating_table.this);
                    tabletext.setText(name + " " + ratingstr);
                    tabletext.setTextSize(24);
                    layout.addView(tabletext);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}