package com.example.itcity.THEORY_TASK.programming;

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

public class Zadprog1 extends AppCompatActivity implements Progtask1SingleChoiceDialog.SingleChoiceListener {
    Dialog dialog;//диалоговое окно
    //кнопки выбрать для задания
    Button button1;
    //кнопка продолжить
    Button check;
    Button back;
    int mark;
    // переменные где будут храниться ответы из выбранных полей
    String answer1;
    Boolean bt1 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progtask1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
        button1 = (Button) findViewById(R.id.progTask2Button1);
        check = (Button) findViewById(R.id.algCheck);
        back = (Button) findViewById(R.id.button5);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent = new Intent(Zadprog1.this, Thprog1.class);
                        startActivity(intent);

                        break;
                    case R.id.progTask2Button1:
                        bt1 = true;
                        DialogFragment singleChoiseDialog1 = new Progtask1SingleChoiceDialog();
                        singleChoiseDialog1.setCancelable(false);
                        singleChoiseDialog1.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;

                    case R.id.algCheck:
                        // проверка на заполнение полей с ответами
                        if (TextUtils.isEmpty(answer1)) {
                            Toast toast = Toast.makeText(Zadprog1.this, "вы не дали ответ в  поле 1", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }



                        String markSTR;
                        if (answer1.equalsIgnoreCase("()")) {
                            //если ответ в поле 1 совпал с правильным ответом то делаем +20 баллов
                            mark += 100;

                        }
                        //вызов диалогового окна с показом количества баллов
                        if (mark>50) {
                            dialog = new Dialog(Zadprog1.this);
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
                                    Intent intent = new Intent(Zadprog1.this, Programming_Home.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark<50) {
                            dialog = new Dialog(Zadprog1.this);
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
                                    Intent intent = new Intent(Zadprog1.this, Programming_Home.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА НЕ МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ УРОВЕНЬ НЕ МЕНЯЕМ;
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

    }
}
