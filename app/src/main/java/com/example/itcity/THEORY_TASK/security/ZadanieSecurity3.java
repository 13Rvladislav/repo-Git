package com.example.itcity.THEORY_TASK.security;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itcity.R;
import com.example.itcity.models.ProfileU;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ZadanieSecurity3 extends AppCompatActivity  implements Sectask3SingleChoiceDialog.SingleChoiceListener {
    Dialog dialog;//диалоговое окно
    //кнопки выбрать для задания
    Button button1;
    //кнопка продолжить
    Button check;
    Button back;
    //пременная ,где будут храниться баллы и пердавться в следющее активити для просмтора результат и после записываться в firebase
    int mark;
    // переменные где будут храниться ответы из выбранных полей
    String answer1;

    FirebaseAuth auth; boolean testing=false;
    FirebaseDatabase DB;
    DatabaseReference users;
    int str;
    ProfileU me = new ProfileU();
    //переменная для проверки выбранной кнопки
    Boolean bt1 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectask3);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        button1 = (Button) findViewById(R.id.button6);
        check = (Button) findViewById(R.id.continueSec);
        back= (Button) findViewById(R.id.bottomSecurityK);
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
                            Intent intent = new Intent(ZadanieSecurity3.this, TheorySecurity3.class);
                            startActivity(intent);
                            break;
                    case R.id.button6:
                        bt1 = true;
                        DialogFragment singleChoiseDialog1 = new Sectask3SingleChoiceDialog();
                        singleChoiseDialog1.setCancelable(false);
                        singleChoiseDialog1.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.continueSec:
                        // проверка на заполнение полей с ответами
                        // проверка на заполнение полей с ответами
                        if (TextUtils.isEmpty(answer1)) {
                            Toast toast = Toast.makeText(ZadanieSecurity3.this, "вы не дали ответ в  поле 1", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }


                        String markSTR;
                        if (answer1.equalsIgnoreCase("Позвонить в банк и узнать о состоянии карты")) {
                            //если ответ в поле 1 совпал с правильным ответом то делаем +20 баллов
                            mark += 100;

                        }


                        //вызов диалогового окна с показом количества баллов
                        if (mark > 50) {
                            dialog = new Dialog(ZadanieSecurity3.this);
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
                                    if ((a < 3)&&(testing==false)) {
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
                            Button back_to_houses = dialog.findViewById(R.id.button10);
                            back_to_houses.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(ZadanieSecurity3.this, Security_HOME.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА!!! МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark < 50) {
                            dialog = new Dialog(ZadanieSecurity3.this);
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
                                    Intent intent = new Intent(ZadanieSecurity3.this, Security_HOME.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА!!! НЕ МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ УРОВЕНЬ НЕ МЕНЯЕМ;
                        }

                }
            }
        };
        button1.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
        check.setOnClickListener(onClickListener);
    }


    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        if (bt1 == true) {
            button1.setText(list[position]);
            answer1 = list[position];
            bt1 = false;
        }


    }


    @Override
    public void onNegativeButtonClicked() {
        button1.setText("Dialog");
    }
}
