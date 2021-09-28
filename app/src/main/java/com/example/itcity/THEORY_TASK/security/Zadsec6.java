package com.example.itcity.THEORY_TASK.security;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.example.itcity.R;
import com.example.itcity.models.ProfileU;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Zadsec6 extends AppCompatActivity {
    Button check;
    Button back;
    EditText answer1;
    EditText answer2;
    EditText answer3;
    FirebaseAuth auth; boolean testing=false;
    FirebaseDatabase DB;
    DatabaseReference users;
    int str;
    ProfileU me = new ProfileU();
    //пременная ,где будут храниться баллы и пердавться в следющее активити для просмтора результат и после записываться в firebase
    int mark;
    Dialog dialog;//диалоговое окно
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectask6);
        check = findViewById(R.id.continueSec);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        answer1 = (EditText) findViewById(R.id.Sec6_1);
        answer2 = (EditText) findViewById(R.id.Sec6_2);
        answer3 = (EditText) findViewById(R.id.Sec6_3);
        back= (Button) findViewById(R.id.bottomSecurityK);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        String UID = user1.getUid();
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomSecurityK:
                        Intent intent = new Intent(Zadsec6.this, TheorySecurity6.class);
                        startActivity(intent);
                        break;
                    case R.id.continueSec:
                        String ans1 = answer1.getText().toString();
                        String ans2 = answer2.getText().toString();
                        String ans3 = answer3.getText().toString();
                        if ((ans1.equalsIgnoreCase("взломали")) || (ans1.equalsIgnoreCase("Взломали"))) {
                            mark+=33;
                        }
                        if ((ans2.equalsIgnoreCase("техподдержку")) || (ans2.equalsIgnoreCase("Техподдержку"))) {
                            mark+=33;
                        }
                        if ((ans3.equalsIgnoreCase("вирусов")) || (ans3.equalsIgnoreCase("Вирусов"))) {
                            mark+=33;
                        }
                        if (mark==99)
                            mark+=1;
                        String markSTR;
                        //вызов диалогового окна с показом количества баллов
                        if (mark>50) {
                            dialog = new Dialog(Zadsec6.this);
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
                                    int a = me.getSecurity();
                                    if ((a < 6)&&(testing==false)) {
                                        mark += str;
                                        users.child(UID).child("mmr").setValue(mark);
                                        testing=true;
                                        a+=1;
                                        users.child(UID).child("security").setValue(a);
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
                                    Intent intent = new Intent(Zadsec6.this, Security_HOME.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark<50) {
                            dialog = new Dialog(Zadsec6.this);
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
                            Button back_to_houses= dialog.findViewById(R.id.button10);
                            back_to_houses.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Zadsec6.this, Security_HOME.class);
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
