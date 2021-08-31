package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.itcity.R;

public class ZadanieAlgorithm2 extends AppCompatActivity implements SingleChoiceDialogFragment.SingleChoiceListener {
    Dialog dialog;//диалоговое окно
    //кнопки выбрать для задания
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    //кнопка продолжить
    Button check;
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
        getSupportActionBar().hide();
        button1 = (Button) findViewById(R.id.algTask2Button1);
        button2 = (Button) findViewById(R.id.algTask2Button2);
        button3 = (Button) findViewById(R.id.algTask2Button3);
        button4 = (Button) findViewById(R.id.algTask2Button4);
        button5 = (Button) findViewById(R.id.algTask2Button5);

        check = (Button) findViewById(R.id.algCheck2);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.algTask2Button1:
                        bt1 = true;
                        DialogFragment singleChoiseDialog1 = new SingleChoiceDialogFragment();
                        singleChoiseDialog1.setCancelable(false);
                        singleChoiseDialog1.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button2:
                        bt2 = true;
                        DialogFragment singleChoiseDialog2 = new SingleChoiceDialogFragment();
                        singleChoiseDialog2.setCancelable(false);
                        singleChoiseDialog2.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button3:
                        bt3 = true;
                        DialogFragment singleChoiseDialog3 = new SingleChoiceDialogFragment();
                        singleChoiseDialog3.setCancelable(false);
                        singleChoiseDialog3.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button4:
                        bt4 = true;
                        DialogFragment singleChoiseDialog4 = new SingleChoiceDialogFragment();
                        singleChoiseDialog4.setCancelable(false);
                        singleChoiseDialog4.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button5:
                        bt5 = true;
                        DialogFragment singleChoiseDialog5 = new SingleChoiceDialogFragment();
                        singleChoiseDialog5.setCancelable(false);
                        singleChoiseDialog5.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algCheck2:
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

                        dialog=new Dialog(ZadanieAlgorithm2.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.markgooddialogwindow);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                       //кнопки начало

                        //кнопки конец
                        TextView result=dialog.findViewById(R.id.mark_for_the_lvl);
                         markSTR = Integer.toString(mark);
                        result.setText(markSTR);
                        dialog.show();//показ окна
                        break;

                }
            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        check.setOnClickListener(onClickListener);
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