package com.example.itcity.THEORY_TASK.computer_Device;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
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

public class Zadcomp3 extends AppCompatActivity {
    Button check;
    Button back;
    EditText answer1;
    EditText answer2;
    EditText answer3;
    EditText answer4;
    int mark;
    Dialog dialog;//диалоговое окно
    FirebaseAuth auth; boolean testing=false;
    FirebaseDatabase DB;
    DatabaseReference users;
    int str;
    ProfileU me = new ProfileU();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtask3);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        check = findViewById(R.id.continueSec);
        answer1 = (EditText) findViewById(R.id.Sec6_1);
        answer2 = (EditText) findViewById(R.id.Sec6_2);
        answer3 = (EditText) findViewById(R.id.Sec6_3);
        answer4 = (EditText) findViewById(R.id.Sec6_4);
        back = findViewById(R.id.bottomSecurityK);
        //для записи  рейтинга и прогресса

        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        String UID = user1.getUid();
        //
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomSecurityK:
                        Intent intent = new Intent(Zadcomp3.this, TheoryComputer3.class);
                        startActivity(intent);
                        break;
                    case R.id.continueSec:
                        String ans1 = answer1.getText().toString();
                        String ans2 = answer2.getText().toString();
                        String ans3 = answer3.getText().toString();
                        String ans4 = answer4.getText().toString();
                        ans1 = ans1.toLowerCase();
                        ans2 = ans2.toLowerCase();
                        ans3 = ans3.toLowerCase();
                        ans4 = ans4.toLowerCase();
                        if ((ans1.equalsIgnoreCase("сердце"))) {
                            mark += 25;
                        }
                        if ((ans2.equalsIgnoreCase("поток"))) {
                            mark += 25;
                        }
                        if ((ans3.equalsIgnoreCase("оперативная"))) {
                            mark += 25;
                        }
                        if ((ans4.equalsIgnoreCase("обработки"))) {
                            mark += 25;
                        }

                        String markSTR;
                        //вызов диалогового окна с показом количества баллов
                        if (mark > 50) {
                            dialog = new Dialog(Zadcomp3.this);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                            dialog.setContentView(R.layout.markgooddialogwindow);//путь к макету диалогового окна
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                            dialog.setCancelable(false);//не закрывается кнопкой назад
                            //кнопки начало

                            //кнопки конец
                            TextView result = dialog.findViewById(R.id.mark_for_the_lvl);
                            markSTR = Integer.toString(mark);
                            result.setText(markSTR);
                            dialog.show();//показ окна
                            users.child(UID).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    me = snapshot.getValue(ProfileU.class);
                                    str = me.getMmr();
                                    int a = me.getPc();
                                    if ((a < 3)&&(testing==false)) {
                                        mark += str;
                                        users.child(UID).child("mmr").setValue(mark);
                                        testing=true;
                                        a+=1;
                                        users.child(UID).child("pc").setValue(a);
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
                                    Intent intent = new Intent(Zadcomp3.this, Comp_Home.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark < 50) {
                            dialog = new Dialog(Zadcomp3.this);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                            dialog.setContentView(R.layout.markbaddialogwindow);//путь к макету диалогового окна
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                            dialog.setCancelable(false);//не закрывается кнопкой назад
                            //кнопки начало

                            //кнопки конец
                            TextView result = dialog.findViewById(R.id.mark_for_the_lvl);
                            markSTR = Integer.toString(mark);
                            result.setText(markSTR);
                            dialog.show();//показ окна
                            Button back_to_houses = dialog.findViewById(R.id.button10);
                            back_to_houses.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Zadcomp3.this, Comp_Home.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА НЕ МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ УРОВЕНЬ НЕ МЕНЯЕМ;
                        }

                }
            }
        };
        check.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}
