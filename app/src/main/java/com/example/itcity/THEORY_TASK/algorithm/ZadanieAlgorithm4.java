package com.example.itcity.THEORY_TASK.algorithm;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import java.util.Random;

public class ZadanieAlgorithm4 extends AppCompatActivity {
    Button back;
    Button go;
    ArrayList<ImageView> listimage = new ArrayList<>();
    ArrayList<ImageView> listfinal = new ArrayList<>();
    float xDelta;
    float yDelta;
    int check1 = 1000, check2 = 730, mark, str;
    ArrayList<TextView> listtext = new ArrayList<>();
    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;
    ProfileU me = new ProfileU();
    Dialog dialog;
    boolean testing = false;
    String markstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtask4);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        back = (Button) findViewById(R.id.button5);
        go = findViewById(R.id.algCheck);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        String UID = user1.getUid();
        RelativeLayout layout = findViewById(R.id.layoutalg4);
        ImageView finaimage1 = findViewById(R.id.imageView41);
        ImageView finaimage2 = findViewById(R.id.imageView42);
        ImageView finaimage3 = findViewById(R.id.imageView40);
        ImageView finaimage4 = findViewById(R.id.imageView43);
        ImageView finaimage5 = findViewById(R.id.imageView44);
        ImageView finaimage6 = findViewById(R.id.imageView433);
        TextView finaltext1 = findViewById(R.id.textView37);
        TextView finaltext2 = findViewById(R.id.textView38);
        ImageView image1 = findViewById(R.id.imageView37);
        ImageView image2 = findViewById(R.id.imageView34);
        ImageView image3 = findViewById(R.id.imageView38);
        ImageView image4 = findViewById(R.id.imageView39);
        ImageView image5 = findViewById(R.id.imageView36);
        ImageView image6 = findViewById(R.id.imageView35);
        listfinal.add(0, finaimage1);
        listimage.add(0, image1);
        listtext.add(0, finaltext1);
        listfinal.add(1, finaimage2);
        listimage.add(1, image2);
        listtext.add(1, finaltext2);
        listfinal.add(2, finaimage3);
        listimage.add(2, image3);
        listfinal.add(3, finaimage4);
        listimage.add(3, image4);
        listfinal.add(4, finaimage5);
        listimage.add(4, image5);
        listfinal.add(5, finaimage6);
        listimage.add(5, image6);

        layout.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < listimage.size(); i++) {
                    listimage.get(i).setOnTouchListener(new View.OnTouchListener() {
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
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) listimage.get(i).getLayoutParams();
                    lParams.leftMargin = new Random().nextInt(layout.getWidth() - listimage.get(i).getWidth());
                    lParams.topMargin = new Random().nextInt(layout.getHeight() - listimage.get(i).getHeight());
                    listimage.get(i).setLayoutParams(lParams);
                }
                for (int i = 0; i < 3; i++) {
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) listfinal.get(i).getLayoutParams();
                    lParams.leftMargin = layout.getWidth() - 800;
                    lParams.topMargin = layout.getHeight() - check1;
                    ;
                    check1 -= 150;
                    listfinal.get(i).setLayoutParams(lParams);
                }
                check1 += 30;
                for (int i = 0; i < listtext.size(); i++) {
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) listtext.get(i).getLayoutParams();
                    lParams.leftMargin = layout.getWidth() - check2;
                    check2 -= 200;
                    lParams.topMargin = layout.getHeight() - check1;
                    listtext.get(i).setLayoutParams(lParams);
                }
                check1 -= 85;
                check2 = 930;
                for (int i = 3; i < 5; i++) {
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) listfinal.get(i).getLayoutParams();
                    lParams.leftMargin = layout.getWidth() - check2;
                    check2 -= 400;
                    lParams.topMargin = layout.getHeight() - check1;
                    listfinal.get(i).setLayoutParams(lParams);
                }
                check1 -= 150;
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) listfinal.get(5).getLayoutParams();
                lParams.leftMargin = layout.getWidth() - 800;
                lParams.topMargin = layout.getHeight() - check1;
                listfinal.get(5).setLayoutParams(lParams);
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent = new Intent(ZadanieAlgorithm4.this, TheoryAlgorithm4.class);
                        startActivity(intent);
                        break;
                    case R.id.algCheck:
                        for (int i = 0; i < listimage.size(); i++) {
                            double tolerance = 100;

                            int xDiff = abs((int) listfinal.get(i).getX() - (int) listimage.get(i).getX());
                            int yDiff = abs((int) listfinal.get(i).getY() - (int) listimage.get(i).getY());
                            if (xDiff <= tolerance && yDiff <= tolerance) {
                                mark += 16;
                            }
                        }
                        if (mark == 96) {
                            mark += 4;
                        }
                        dialog = new Dialog(ZadanieAlgorithm4.this);
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
                                if (a == 3) {
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
                        Button back_to_houses = dialog.findViewById(R.id.button10);
                        back_to_houses.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ZadanieAlgorithm4.this, Algorithm_HOME.class);
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
        back.setOnClickListener(onClickListener);
        go.setOnClickListener(onClickListener);
    }
}