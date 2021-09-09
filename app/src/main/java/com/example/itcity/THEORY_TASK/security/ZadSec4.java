package com.example.itcity.THEORY_TASK.security;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itcity.R;

public class ZadSec4 extends AppCompatActivity {
    Integer mark=0;
    Dialog dialog;//диалоговое окно
    //
    CheckBox checkbox1, checkbox2, checkbox3, checkbox4;

    Button check;
    Button back;
    Boolean check1 = false, check2 = false, check3 = false, check4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectask4);

        checkbox1 = findViewById(R.id.checkBox1);
        checkbox2 = findViewById(R.id.checkBox2);
        checkbox3 = findViewById(R.id.checkBox3);
        checkbox4 = findViewById(R.id.checkBox4);

        check = findViewById(R.id.continueSec);
        back= (Button) findViewById(R.id.bottomSecurityK);


        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomSecurityK:
                        Intent intent = new Intent(ZadSec4.this, TheorySecurity4.class);
                        startActivity(intent);
                        break;
                    case R.id.checkBox1:
                        if(checkbox1.isChecked())
                        check1=true;
                        else
                            check1=false;
                        break;
                    case R.id.checkBox2:
                        if(checkbox2.isChecked())
                            check2=true;
                        else
                            check2=false;
                        break;
                    case R.id.checkBox3:
                        if(checkbox3.isChecked())
                            check3=true;
                        else
                            check3=false;
                        break;
                    case R.id.checkBox4:
                        if(checkbox4.isChecked())
                            check4=true;
                        else
                            check4=false;
                        break;
                    case R.id.continueSec:
                        // проверка выбранных чекбоксов
                        if (check2 == true)
                            mark += 33;
                        if (check3 == true)
                            mark += 33;
                        if (check4 == true)
                            mark += 33;
                        if (check1 == true)
                            mark -= 33;
                        if (mark == 99)
                            mark += 1;
                        String markSTR;
                        //вызов диалогового окна с показом количества баллов
                        if (mark>50) {
                            dialog = new Dialog(ZadSec4.this);
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
                            Button back_to_houses= dialog.findViewById(R.id.button10);
                            back_to_houses.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(ZadSec4.this, Security_HOME.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark<50) {
                            dialog = new Dialog(ZadSec4.this);
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
                                    Intent intent = new Intent(ZadSec4.this, Security_HOME.class);
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
        check.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }

}
