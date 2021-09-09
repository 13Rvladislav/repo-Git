package com.example.itcity.THEORY_TASK.computer_Device;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.itcity.R;
import com.example.itcity.THEORY_TASK.security.Security_HOME;
import com.example.itcity.THEORY_TASK.security.ZadSec4;

public class ZadComp1 extends AppCompatActivity {
    Integer mark = 0;
    Dialog dialog;//диалоговое окно
    //
    CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8, checkbox9, checkbox10, checkbox11, checkbox12;
    Button back;
    Button checkcont;
    Boolean check1 = false, check2 = false, check3 = false, check4 = false, check5 = false, check6 = false, check7 = false,
            check8 = false, check9 = false, check10 = false, check11 = false, check12 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtask1);
        getSupportActionBar().hide();
        checkbox1 = findViewById(R.id.checkBox1);
        checkbox2 = findViewById(R.id.checkBox2);
        checkbox3 = findViewById(R.id.checkBox3);
        checkbox4 = findViewById(R.id.checkBox4);
        checkbox5 = findViewById(R.id.checkBox5);
        checkbox6 = findViewById(R.id.checkBox6);
        checkbox7 = findViewById(R.id.checkBox7);
        checkbox8 = findViewById(R.id.checkBox8);
        checkbox9 = findViewById(R.id.checkBox9);
        checkbox10 = findViewById(R.id.checkBox10);
        checkbox11 = findViewById(R.id.checkBox11);
        checkbox12 = findViewById(R.id.checkBox12);
        back = findViewById(R.id.bottomCompDevK1);
        checkcont = findViewById(R.id.continueSec);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomCompDevK1:
                        Intent intent = new Intent(ZadComp1.this, TheoryComputer1.class);
                        startActivity(intent);
                        break;
                    case R.id.checkBox1:
                        if (checkbox1.isChecked())
                            check1 = true;
                        else
                            check1 = false;
                        break;
                    case R.id.checkBox2:
                        if (checkbox2.isChecked())
                            check2 = true;
                        else
                            check2 = false;
                        break;
                    case R.id.checkBox3:
                        if (checkbox3.isChecked())
                            check3 = true;
                        else
                            check3 = false;
                        break;
                    case R.id.checkBox4:
                        if (checkbox4.isChecked())
                            check4 = true;
                        else
                            check4 = false;
                        break;
                    case R.id.checkBox5:
                        if (checkbox5.isChecked())
                            check5 = true;
                        else
                            check5 = false;
                        break;
                    case R.id.checkBox6:
                        if (checkbox6.isChecked())
                            check6 = true;
                        else
                            check6 = false;
                        break;
                    case R.id.checkBox7:
                        if (checkbox7.isChecked())
                            check7 = true;
                        else
                            check7 = false;
                        break;
                    case R.id.checkBox8:
                        if (checkbox8.isChecked())
                            check8 = true;
                        else
                            check2 = false;
                        break;
                    case R.id.checkBox9:
                        if (checkbox9.isChecked())
                            check9 = true;
                        else
                            check9 = false;
                        break;
                    case R.id.checkBox10:
                        if (checkbox10.isChecked())
                            check10 = true;
                        else
                            check10 = false;
                        break;
                    case R.id.checkBox11:
                        if (checkbox11.isChecked())
                            check11 = true;
                        else
                            check11 = false;
                        break;
                    case R.id.checkBox12:
                        if (checkbox12.isChecked())
                            check12 = true;
                        else
                            check12 = false;
                        break;
                    case R.id.continueSec:
                        // проверка выбранных чекбоксов
                        if (check1 == true)
                            mark -= 14;
                        if (check2 == true)
                            mark -= 14;
                        if (check3 == true)
                            mark += 20;
                        if (check4 == true)
                            mark -= 14;
                        if (check5 == true)
                            mark += 20;
                        if (check6 == true)
                            mark += 20;
                        if (check7 == true)
                            mark -= 14;
                        if (check8 == true)
                            mark -= 14;
                        if (check9 == true)
                            mark += 20;
                        if (check10 == true)
                            mark -= 14;
                        if (check11 == true)
                            mark += 20;
                        if (check12 == true)
                            mark -= 14;
                        if (mark < 0)
                            mark = 0;
                        String markSTR;
                        //вызов диалогового окна с показом количества баллов
                        if (mark > 50) {
                            dialog = new Dialog(ZadComp1.this);
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
                                    Intent intent = new Intent(ZadComp1.this, Computer_Home.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark < 50) {
                            dialog = new Dialog(ZadComp1.this);
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
                                    Intent intent = new Intent(ZadComp1.this, Computer_Home.class);
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
        checkbox5.setOnClickListener(onClickListener);
        checkbox6.setOnClickListener(onClickListener);
        checkbox7.setOnClickListener(onClickListener);
        checkbox8.setOnClickListener(onClickListener);
        checkbox9.setOnClickListener(onClickListener);
        checkbox10.setOnClickListener(onClickListener);
        checkbox11.setOnClickListener(onClickListener);
        checkbox12.setOnClickListener(onClickListener);
        checkcont.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }

}
