package com.example.itcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class rating_table extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ProfileU DB = new ProfileU();
    String name, ratingstr, numberstr;
    int rating, number = 0;
    ArrayList<ProfileU> listdb = new ArrayList<>(), listout = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_table);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
        TableLayout layout = findViewById(R.id.mmrtable);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        String UID = user1.getUid();

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
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
                    TableRow newrow = new TableRow(rating_table.this);
                    layout.addView(newrow);
                    newrow.addView(tabletext1);
                    newrow.addView(tabletext2);
                    newrow.addView(tabletext3);
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