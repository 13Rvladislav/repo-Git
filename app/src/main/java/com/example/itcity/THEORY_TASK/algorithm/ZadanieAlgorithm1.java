package com.example.itcity.THEORY_TASK.algorithm;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ZadanieAlgorithm1 extends AppCompatActivity {
    Button button5;
    Button algcheck;
    ArrayList<ImageView> Listimage = new ArrayList<>();
    ArrayList<ImageView> Listfinal = new ArrayList<>();
    float xDelta;
    float yDelta;
    int check1 = 1000, mark, str;
    String markstr;
    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;
    ProfileU me = new ProfileU();
    Dialog dialog;
    boolean testing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtask1);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        button5 = findViewById(R.id.button5);
        algcheck = findViewById(R.id.algCheck);
        RelativeLayout layout = findViewById(R.id.layoutalgoritm99);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        String UID = user1.getUid();
        ImageView image1 = findViewById(R.id.imageView54);
        ImageView image2 = findViewById(R.id.imageView49);
        ImageView image3 = findViewById(R.id.imageView48);
        ImageView image4 = findViewById(R.id.imageView58);
        ImageView image5 = findViewById(R.id.imageView56);
        ImageView image6 = findViewById(R.id.imageView50);
        Listimage.add(0, image1);
        Listimage.add(1, image2);
        Listimage.add(2, image3);
        Listimage.add(3, image4);
        Listimage.add(4, image5);
        Listimage.add(5, image6);
        ImageView finalimage1 = findViewById(R.id.imageView52);
        ImageView finalimage2 = findViewById(R.id.imageView53);
        ImageView finalimage3 = findViewById(R.id.imageView59);
        ImageView finalimage4 = findViewById(R.id.imageView57);
        ImageView finalimage5 = findViewById(R.id.imageView55);
        ImageView finalimage6 = findViewById(R.id.imageView51);
        Listfinal.add(0, finalimage1);
        Listfinal.add(1, finalimage2);
        Listfinal.add(2, finalimage3);
        Listfinal.add(3, finalimage4);
        Listfinal.add(4, finalimage5);
        Listfinal.add(5, finalimage6);

        layout.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Listimage.size(); i++) {
                    Listimage.get(i).setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent event) {
                            float x = event.getRawX();
                            float y = event.getRawY();

                            RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                                case MotionEvent.ACTION_DOWN:
                                    xDelta = x - lParams.leftMargin;
                                    yDelta = y - lParams.topMargin;
                                    break;
                                case MotionEvent.ACTION_MOVE:
                                    lParams.leftMargin = (int) (x - xDelta);
                                    lParams.topMargin = (int) (y - yDelta);
                                    view.setLayoutParams(lParams);
                                    break;
                                case MotionEvent.ACTION_UP:
                                    break;
                            }
                            return true;
                        }
                    });
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) Listimage.get(i).getLayoutParams();
                    lParams.leftMargin = new Random().nextInt(layout.getWidth() - Listimage.get(i).getWidth());
                    lParams.topMargin = new Random().nextInt(layout.getHeight() - Listimage.get(i).getHeight());
                    Listimage.get(i).setLayoutParams(lParams);
                }
                for (int i = 0; i < Listfinal.size(); i++) {
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) Listfinal.get(i).getLayoutParams();
                    lParams.leftMargin = layout.getWidth() - 800;
                    lParams.topMargin = layout.getHeight() - check1;;
                    check1 -= 150;
                    Listfinal.get(i).setLayoutParams(lParams);
                }
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent1 = new Intent(ZadanieAlgorithm1.this, TheoryAlgorithm1.class);
                        startActivity(intent1);
                        break;
                    case R.id.algCheck:
                        for (int i = 0; i < Listimage.size(); i++) {
                            double tolerance = sqrt(pow(Listimage.get(i).getWidth(), 2) + pow(Listimage.get(i).getHeight(), 2)) / 20;

                            int xDiff = abs((int) Listfinal.get(i).getX() - (int) Listimage.get(i).getX());
                            int yDiff = abs((int) Listfinal.get(i).getY() - (int) Listimage.get(i).getY());
                            if (xDiff <= tolerance && yDiff <= tolerance) {
                                mark += 16;
                            }
                        }
                        if (mark == 96) {mark += 4;}
                        dialog = new Dialog(ZadanieAlgorithm1.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.markgooddialogwindow);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        //кнопки начало

                        //кнопки конец
                        TextView result = dialog.findViewById(R.id.mark_for_the_lvl);
                        markstr = Integer.toString(mark);
                        result.setText(markstr);
                        dialog.show();//показ окна
                        users.child(UID).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                me = snapshot.getValue(ProfileU.class);
                                int a = me.getAlgorithm();
                                if (a == 0) {
                                    if ((a < 6) && (testing == false)) {
                                        str = me.getMmr();
                                        mark += str;
                                        users.child(UID).child("mmr").setValue(mark);
                                        testing = true;
                                        a += 1;
                                        users.child(UID).child("algorithm").setValue(a);
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        Button back_to_houses= dialog.findViewById(R.id.button10);
                        back_to_houses.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ZadanieAlgorithm1.this, Algorithm_HOME.class);
                                startActivity(intent);
                            }
                        });
                        //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                        break;
                    default:
                        break;
                }
            }
        };
        button5.setOnClickListener(onClickListener);
        algcheck.setOnClickListener(onClickListener);
    }
}