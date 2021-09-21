package com.example.itcity.THEORY_TASK.programming;

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
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.itcity.ActivityMap;
import com.example.itcity.R;

public class Zadp11 extends AppCompatActivity {
    Integer mark = 0;
    Dialog dialog;//диалоговое окно
    //
    CheckBox checkbox1, checkbox2, checkbox3,checkbox4;
    Button back;
    Button checkcont;
    Boolean check1 = false, check2 = false, check3 = false,check4 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progtask11);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        checkbox1 = findViewById(R.id.checkBox);
        checkbox2 = findViewById(R.id.checkBox13);
        checkbox3 = findViewById(R.id.checkBox14);
        checkbox4 = findViewById(R.id.checkBox15);
        back = findViewById(R.id.bottomSecurityK);
        checkcont = findViewById(R.id.continueSec);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomSecurityK:
                        Intent intent = new Intent(Zadp11.this, Thpr11.class);
                        startActivity(intent);
                        break;
                    case R.id.checkBox:
                        if (checkbox1.isChecked())
                            check1 = true;
                        else
                            check1 = false;
                        break;
                    case R.id.checkBox13:
                        if (checkbox2.isChecked())
                            check2 = true;
                        else
                            check2 = false;
                        break;
                    case R.id.checkBox14:
                        if (checkbox3.isChecked())
                            check3 = true;
                        else
                            check3 = false;
                        break;
                    case R.id. checkBox15:
                        if (checkbox4.isChecked())
                            check4 = true;
                        else
                            check4 = false;
                        break;
                    case R.id.continueSec:
                        // проверка выбранных чекбоксов
                        if (check1 == true)
                            mark -= 50;
                        if (check2 == true)
                            mark -= 50;
                        if (check3 == true)
                            mark += 50;
                        if (check4 == true)
                            mark += 50;

                        if (mark < 0)
                            mark = 0;
                        String markSTR;
                        //вызов диалогового окна с показом количества баллов
                        if (mark >= 50) {
                            dialog = new Dialog(Zadp11.this);
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
                                    Intent intent = new Intent(Zadp11.this, Programming_Home.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark < 50) {
                            dialog = new Dialog(Zadp11.this);
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
                                    Intent intent = new Intent(Zadp11.this, Programming_Home.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА НЕ МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ УРОВЕНЬ НЕ МЕНЯЕМ;
                        }

                }
            }
        };
        checkbox1.setOnClickListener(onClickListener);
        checkbox2.setOnClickListener(onClickListener);
        checkbox3.setOnClickListener(onClickListener);
        checkbox4.setOnClickListener(onClickListener);
        checkcont.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }

}
