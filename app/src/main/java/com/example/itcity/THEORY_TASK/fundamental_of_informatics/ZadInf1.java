package com.example.itcity.THEORY_TASK.fundamental_of_informatics;

import static java.lang.Math.abs;

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
import com.example.itcity.THEORY_TASK.algorithm.Algorithm_HOME;
import com.example.itcity.THEORY_TASK.algorithm.ZadanieAlgorithm4;
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

public class ZadInf1 extends AppCompatActivity {
    Button next;
    Button back;
    ArrayList<ImageView> listfinal = new ArrayList<>();
    ArrayList<TextView> listtext = new ArrayList<>();
    ArrayList<ImageView> listtask = new ArrayList<>();
    float xDelta;
    float yDelta;
    int str, mark, check1, check2;
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
        getSupportActionBar().hide();
        setContentView(R.layout.inftask1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        next = findViewById(R.id.algCheck);
        back = findViewById(R.id.bottomTeoryK1);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        String UID = user1.getUid();
        RelativeLayout layout = findViewById(R.id.layoutinf);
        ImageView finalimage1 = findViewById(R.id.imageView5);
        ImageView finalimage2 = findViewById(R.id.imageView7);
        ImageView finalimage3 = findViewById(R.id.imageView9);
        ImageView image1 = findViewById(R.id.imageView4);
        ImageView image2 = findViewById(R.id.imageView6);
        ImageView image3 = findViewById(R.id.imageView8);
        TextView text1 = findViewById(R.id.textView8);
        TextView text2 = findViewById(R.id.textView9);
        TextView text3 = findViewById(R.id.textView13);
        listfinal.add(0, finalimage1);
        listtext.add(0, text1);
        listfinal.add(1, finalimage2);
        listtext.add(1, text2);
        listfinal.add(2, finalimage3);
        listtext.add(2, text3);
        listtask.add(0, image1);
        listtask.add(1, image2);
        listtask.add(2, image3);

        layout.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < listtext.size(); i++) {
                    listtext.get(i).setOnTouchListener(new View.OnTouchListener() {
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
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) listtext.get(i).getLayoutParams();
                    lParams.leftMargin = new Random().nextInt(layout.getWidth() - listtext.get(i).getWidth());;
                    lParams.topMargin = new Random().nextInt(layout.getHeight() - listtext.get(i).getHeight());
                    listtext.get(i).setLayoutParams(lParams);
                }
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.algCheck:
                        for (int i = 0; i < listtext.size(); i++) {
                            double toleranceY = 10;
                            double toleranceX = 340;

                            int xDiff = abs((int) listfinal.get(i).getX() - (int) listtext.get(i).getX());
                            int yDiff = abs((int) listfinal.get(i).getY() - (int) listtext.get(i).getY());
                            if (xDiff <= toleranceX && yDiff <= toleranceY) {
                                mark += 33;
                            }
                        }
                        if (mark == 99) {
                            mark += 1;
                        }
                        dialog = new Dialog(ZadInf1.this);
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
                                int a = me.getInformatic();
                                if (a == 0) {
                                    if ((a < 6) && (testing == false)) {
                                        str = me.getMmr();
                                        mark += str;
                                        users.child(UID).child("mmr").setValue(mark);
                                        testing = true;
                                        a += 1;
                                        users.child(UID).child("informatic").setValue(a);
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
                                Intent intent = new Intent(ZadInf1.this, Informatica_HOME.class);
                                startActivity(intent);
                            }
                        });
                        //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                        break;
                    case R.id.bottomTeoryK1:
                        Intent intent = new Intent(ZadInf1.this, ThInf1.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        next.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}
