package com.example.itcity.THEORY_TASK.programming;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

public class Zadp5 extends AppCompatActivity {
    Dialog dialog;//диалоговое окно
    //кнопки выбрать для задания

    //кнопка продолжить
    Button check;
    Button back;
    int mark;
    EditText answer1;
    EditText answer2;
    EditText answer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progtask5);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        check = (Button) findViewById(R.id.continueSec);
        back = (Button) findViewById(R.id.bottomSecurityK);
        answer1 = (EditText) findViewById(R.id.prog5_1);
        answer2 = (EditText) findViewById(R.id.prog5_2);
        answer3 = (EditText) findViewById(R.id.Prog4_1);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomSecurityK:
                        Intent intent1 = new Intent(Zadp5.this, Thpr5.class);
                        startActivity(intent1);
                        break;
                    case R.id.continueSec:
                        String ans1 = answer1.getText().toString();
                        String ans2 = answer2.getText().toString();
                        String ans3 = answer3.getText().toString();
                        ans1 = ans1.toLowerCase();
                        ans2 = ans2.toLowerCase();
                        ans3 = ans3.toLowerCase();
                        if ((ans1.equalsIgnoreCase("//"))) {
                            mark += 33;
                        }
                        if ((ans2.equalsIgnoreCase("/*"))) {
                            mark += 33;
                        }
                        if ((ans3.equalsIgnoreCase("*/"))) {
                            mark += 33;
                        }
                        if (mark == 99)
                            mark++;

                        String markSTR;
                        //вызов диалогового окна с показом количества баллов
                        if (mark >= 50) {
                            dialog = new Dialog(Zadp5.this);
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

                            Button back_to_houses = dialog.findViewById(R.id.button10);
                            back_to_houses.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(Zadp5.this, Programming_Home.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark < 50) {
                            dialog = new Dialog(Zadp5.this);
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
                                    Intent intent = new Intent(Zadp5.this, Programming_Home.class);
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
