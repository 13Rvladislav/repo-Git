package com.example.itcity.THEORY_TASK.fundamental_of_informatics;
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
import com.example.itcity.THEORY_TASK.computer_Device.Computer_Home;
import com.example.itcity.THEORY_TASK.computer_Device.TheoryComputer1;
import com.example.itcity.THEORY_TASK.computer_Device.ZadComp1;

public class ZadInf7 extends AppCompatActivity {
    Button button8;
    Integer mark = 0;
    Dialog dialog;//диалоговое окно
    //
    CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8;
    Button back;
    Button checkcont;
    Boolean check1 = false, check2 = false, check3 = false, check4 = false, check5 = false, check6 = false, check7 = false,
            check8 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.inftask7);
        button8=findViewById(R.id.button8);
        checkbox1 = findViewById(R.id.icheckBox1);
        checkbox2 = findViewById(R.id.icheckBox2);
        checkbox3 = findViewById(R.id.icheckBox3);
        checkbox4 = findViewById(R.id.icheckBox4);
        checkbox5 = findViewById(R.id.icheckBox5);
        checkbox6 = findViewById(R.id.icheckBox6);
        checkbox7 = findViewById(R.id.icheckBox7);
        checkbox8 = findViewById(R.id.icheckBox8);
        back = findViewById(R.id.bottomCompDevK1);
        checkcont = findViewById(R.id.continueSec);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomCompDevK1:
                        Intent intent = new Intent(ZadInf7.this, ThInf7.class);
                        startActivity(intent);
                        break;
                    case R.id.icheckBox1:
                        if (checkbox1.isChecked())
                            check1 = true;
                        else
                            check1 = false;
                        break;
                    case R.id.icheckBox2:
                        if (checkbox2.isChecked())
                            check2 = true;
                        else
                            check2 = false;
                        break;
                    case R.id.icheckBox3:
                        if (checkbox3.isChecked())
                            check3 = true;
                        else
                            check3 = false;
                        break;
                    case R.id.icheckBox4:
                        if (checkbox4.isChecked())
                            check4 = true;
                        else
                            check4 = false;
                        break;
                    case R.id.icheckBox5:
                        if (checkbox5.isChecked())
                            check5 = true;
                        else
                            check5 = false;
                        break;
                    case R.id.icheckBox6:
                        if (checkbox6.isChecked())
                            check6 = true;
                        else
                            check6 = false;
                        break;
                    case R.id.icheckBox7:
                        if (checkbox7.isChecked())
                            check7 = true;
                        else
                            check7 = false;
                        break;
                    case R.id.icheckBox8:
                        if (checkbox8.isChecked())
                            check8 = true;
                        else
                            check2 = false;
                        break;

                    case R.id.continueSec:
                        // проверка выбранных чекбоксов
                        if (check1 == true)
                            mark -= 12;
                        if (check2 == true)
                            mark -= 12;
                        if (check3 == true)
                            mark -= 12;
                        if (check4 == true)
                            mark += 33;
                        if (check5 == true)
                            mark += 33;
                        if (check6 == true)
                            mark -= 12;
                        if (check7 == true)
                            mark += 33;
                        if (check8 == true)
                            mark -= 12;
                        if (mark < 0)
                            mark = 0;
                        if(mark==99)
                            mark++;
                        String markSTR;
                        //вызов диалогового окна с показом количества баллов
                        if (mark > 50) {
                            dialog = new Dialog(ZadInf7.this);
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
                                    Intent intent = new Intent(ZadInf7.this, Informatica_HOME.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark < 50) {
                            dialog = new Dialog(ZadInf7.this);
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
                                    Intent intent = new Intent(ZadInf7.this, Informatica_HOME.class);
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
        checkcont.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }

}
