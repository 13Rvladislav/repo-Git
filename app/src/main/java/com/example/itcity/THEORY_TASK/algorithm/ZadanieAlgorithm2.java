package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.itcity.R;

public class ZadanieAlgorithm2 extends AppCompatActivity implements SingleChoiceDialogFragment.SingleChoiceListener {
    //кнопки выбрать для задания
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
//кнопка продолжить
    Button check;
    //пременная ,где будут храниться баллы и пердавться в следющее активити для просмтора результат и после записываться в firbase
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
                        if (answer1.equalsIgnoreCase("")) {
                            //если ответ в поле 1 совпал с правильным ответом то делаем +20баллов
                        }
                        if (answer2.equalsIgnoreCase("")) {
                            //если ответ в поле 2 совпал с правильным ответом то делаем +20баллов
                        }
                        if (answer3.equalsIgnoreCase("")) {
                             //если ответ в поле 3 совпал с правильным ответом то делаем +20баллов
                        }
                        if (answer4.equalsIgnoreCase("")) {
                            //если ответ в поле 4 совпал с правильным ответом то делаем +20баллов
                        }
                        if (answer5.equalsIgnoreCase("")) {
                            //если ответ в поле 5 совпал с правильным ответом то делаем +20баллов
                        }
                            //вызов диалогового окна с показом количества баллов
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
            bt1 = false;
        }
        if (bt2 == true) {
            button2.setText(list[position]);
            bt2 = false;
        }
        if (bt3 == true) {
            button3.setText(list[position]);
            bt3 = false;
        }
        if (bt4 == true) {
            button4.setText(list[position]);
            bt4 = false;
        }
        if (bt5 == true) {
            button5.setText(list[position]);
            bt5 = false;

        }
    }

    @Override
    public void onNegativeButtonClicked() {
        button1.setText("Dialog");
    }
}