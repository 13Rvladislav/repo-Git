package com.example.itcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import com.example.itcity.models.ProfileU;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class rating_table extends AppCompatActivity {
    Button back;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ProfileU DB = new ProfileU();
    String name, ratingstr, numberstr;
    int rating, number = 0;
    ArrayList<ProfileU> listdb = new ArrayList<>(), listout = new ArrayList<>();
    Boolean update = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
        TableLayout layout = findViewById(R.id.mmrtable);
        back = findViewById(R.id.button5);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        String UID = user1.getUid();
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        //кнопка назад
                        Intent intent1 = new Intent(rating_table.this, ActivityMap.class);
                        startActivity(intent1);
                        break;

                }
            }
        };
        back.setOnClickListener(onClickListener);
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (update) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DB = dataSnapshot.getValue(ProfileU.class);
                        listdb.add(DB);
                    }
                    listout = arraysort(listdb);
                    for (int i = 0; i < listout.size(); i++) {
                        number += 1;
                        numberstr = Integer.toString(number);
                        name = listout.get(i).getName();
                        rating = listout.get(i).getMmr();
                        ratingstr = Integer.toString(rating);
                        TextView tabletext1 = new TextView(rating_table.this);
                        TextView tabletext2 = new TextView(rating_table.this);
                        TextView tabletext3 = new TextView(rating_table.this);
                        tabletext1.setText(numberstr);
                        tabletext2.setText(name);
                        tabletext3.setText(ratingstr);
                        tabletext1.setTextSize(24);
                        tabletext2.setTextSize(24);
                        tabletext3.setTextSize(24);
                        tabletext1.setTextColor(Color.parseColor("#000000"));
                        tabletext2.setTextColor(Color.parseColor("#000000"));
                        tabletext3.setTextColor(Color.parseColor("#000000"));
                        TableRow newrow = new TableRow(rating_table.this);
                        layout.addView(newrow);
                        newrow.addView(tabletext1);
                        newrow.addView(tabletext2);
                        newrow.addView(tabletext3);
                    }
                    update = false;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private ArrayList<ProfileU> arraysort(ArrayList<ProfileU> list) {
        ArrayList<Integer> mmrlist = new ArrayList<>();
        ArrayList<ProfileU> finallist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            mmrlist.add(list.get(i).getMmr());
        }
        Collections.sort(mmrlist);
        Collections.reverse(mmrlist);
        for (int i = 0; i < mmrlist.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (mmrlist.get(i) == list.get(j).getMmr()) {
                    finallist.add(list.get(j));
                }
            }
        }
        return finallist;
    }
}