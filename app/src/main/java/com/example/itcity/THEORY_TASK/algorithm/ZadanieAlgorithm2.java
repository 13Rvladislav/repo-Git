package com.example.itcity.THEORY_TASK.algorithm;

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

import com.example.itcity.ActivityRegistration;
import com.example.itcity.R;

public class ZadanieAlgorithm2 extends AppCompatActivity implements Algtask2SingleChoiceDialog.SingleChoiceListener {
    Dialog dialog;//диалоговое окно
    //кнопки выбрать для задания
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    //кнопка продолжить и назад
    Button check;
    Button back;
    //пременная ,где будут храниться баллы и пердавться в следющее активити для просмтора результат и после записываться в firebase
    int mark;
    // переменные где будут храниться ответы из выбранных полей
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;
    //переменная для проверки выбранной кнопки
    Boolean bt1 = false;
    Boolean bt2 = false;
    Boolean bt3 = false;
    Boolean bt4 = false;
    Boolean bt5 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtask2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
        button1 = (Button) findViewById(R.id.algTask2Button1);
        button2 = (Button) findViewById(R.id.algTask2Button2);
        button3 = (Button) findViewById(R.id.algTask2Button3);
        button4 = (Button) findViewById(R.id.algTask2Button4);
        button5 = (Button) findViewById(R.id.algTask2Button5);
        back= (Button) findViewById(R.id.button5);;
        check = (Button) findViewById(R.id.algCheck);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent = new Intent(ZadanieAlgorithm2.this, TheoryAlgorithm2.class);
                        startActivity(intent);
                        break;
                    case R.id.algTask2Button1:
                        bt1 = true;
                        DialogFragment singleChoiseDialog1 = new Algtask2SingleChoiceDialog();
                        singleChoiseDialog1.setCancelable(false);
                        singleChoiseDialog1.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button2:
                        bt2 = true;
                        DialogFragment singleChoiseDialog2 = new Algtask2SingleChoiceDialog();
                        singleChoiseDialog2.setCancelable(false);
                        singleChoiseDialog2.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button3:
                        bt3 = true;
                        DialogFragment singleChoiseDialog3 = new Algtask2SingleChoiceDialog();
                        singleChoiseDialog3.setCancelable(false);
                        singleChoiseDialog3.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button4:
                        bt4 = true;
                        DialogFragment singleChoiseDialog4 = new Algtask2SingleChoiceDialog();
                        singleChoiseDialog4.setCancelable(false);
                        singleChoiseDialog4.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button5:
                        bt5 = true;
                        DialogFragment singleChoiseDialog5 = new Algtask2SingleChoiceDialog();
                        singleChoiseDialog5.setCancelable(false);
                        singleChoiseDialog5.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algCheck:
                        // проверка на заполнение полей с ответами
                        if (TextUtils.isEmpty(answer1)) {
                            Toast toast = Toast.makeText(ZadanieAlgorithm2.this, "вы не дали ответ в  поле 1", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }

                        if (TextUtils.isEmpty(answer2)) {
                            Toast toast = Toast.makeText(ZadanieAlgorithm2.this, "вы не дали ответ в  поле 2", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer3)) {
                            Toast toast = Toast.makeText(ZadanieAlgorithm2.this, "вы не дали ответ в  поле 3", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer4)) {
                            Toast toast = Toast.makeText(ZadanieAlgorithm2.this, "вы не дали ответ в  поле 4", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer5)) {
                            Toast toast = Toast.makeText(ZadanieAlgorithm2.this, "вы не дали ответ в  поле 5", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }


                        String markSTR;
                        if (answer1.equalsIgnoreCase("Результативность")) {
                            //если ответ в поле 1 совпал с правильным ответом то делаем +20 баллов
                            mark += 20;

                        }
                        if (answer2.equalsIgnoreCase("Дискретность")) {
                            //если ответ в поле 2 совпал с правильным ответом то делаем +20 баллов
                            mark += 20;
                        }
                        if (answer3.equalsIgnoreCase("Детерминированность")) {
                            //если ответ в поле 3 совпал с правильным ответом то делаем +20 баллов
                            mark += 20;
                        }
                        if (answer4.equalsIgnoreCase("Результативность")) {
                            //если ответ в поле 4 совпал с правильным ответом то делаем +20 баллов
                            mark += 20;
                        }
                        if (answer5.equalsIgnoreCase("Массовость")) {
                            //если ответ в поле 5 совпал с правильным ответом то делаем +20 баллов
                            mark += 20;
                        }
                        //вызов диалогового окна с показом количества баллов
                        if (mark>50) {
                            dialog = new Dialog(ZadanieAlgorithm2.this);
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
                                    Intent intent = new Intent(ZadanieAlgorithm2.this, Algorithm_HOME.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark<50) {
                            dialog = new Dialog(ZadanieAlgorithm2.this);
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
                                    Intent intent = new Intent(ZadanieAlgorithm2.this, Algorithm_HOME.class);
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
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        check.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        if (bt1 == true) {
            button1.setText(list[position]);
            answer1 = list[position];
            bt1 = false;
        }
        if (bt2 == true) {
            button2.setText(list[position]);
            answer2 = list[position];
            bt2 = false;
        }
        if (bt3 == true) {
            button3.setText(list[position]);
            answer3 = list[position];
            bt3 = false;
        }
        if (bt4 == true) {
            button4.setText(list[position]);
            answer4 = list[position];
            bt4 = false;
        }
        if (bt5 == true) {
            button5.setText(list[position]);
            answer5 = list[position];
            bt5 = false;

        }
    }

    @Override
    public void onNegativeButtonClicked() {
        button1.setText("Dialog");
    }
}