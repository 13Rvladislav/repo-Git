package com.example.itcity.THEORY_TASK.computer_Device;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.itcity.R;

public class Zadcomp5 extends AppCompatActivity implements Comptask5SingleChoiceDialog.SingleChoiceListener {
    Dialog dialog;//диалоговое окно
    //кнопки выбрать для задания
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    //кнопка продолжить
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
    String answer6;
    String answer7;
    String answer8;
    //переменная для проверки выбранной кнопки
    Boolean bt1 = false;
    Boolean bt2 = false;
    Boolean bt3 = false;
    Boolean bt4 = false;
    Boolean bt5 = false;
    Boolean bt6 = false;
    Boolean bt7 = false;
    Boolean bt8 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comtask5);
        getSupportActionBar().hide();
        button1 = (Button) findViewById(R.id.algTask2Button1);
        button2 = (Button) findViewById(R.id.algTask2Button2);
        button3 = (Button) findViewById(R.id.algTask2Button3);
        button4 = (Button) findViewById(R.id.algTask2Button11);
        button5 = (Button) findViewById(R.id.algTask2Button12);
        button6 = (Button) findViewById(R.id.algTask2Button6);
        button7 = (Button) findViewById(R.id.algTask2Button7);
        button8 = (Button) findViewById(R.id.algTask2Button8);
        check = (Button) findViewById(R.id.algCheck);
        back = (Button) findViewById(R.id.button5);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent = new Intent(Zadcomp5.this, TheoryComputer5.class);
                        startActivity(intent);
                        break;
                    case R.id.algTask2Button1:
                        bt1 = true;
                        DialogFragment singleChoiseDialog1 = new Comptask5SingleChoiceDialog();
                        singleChoiseDialog1.setCancelable(false);
                        singleChoiseDialog1.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button2:
                        bt2 = true;
                        DialogFragment singleChoiseDialog2 = new Comptask5SingleChoiceDialog();
                        singleChoiseDialog2.setCancelable(false);
                        singleChoiseDialog2.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button3:
                        bt3 = true;
                        DialogFragment singleChoiseDialog3 = new Comptask5SingleChoiceDialog();
                        singleChoiseDialog3.setCancelable(false);
                        singleChoiseDialog3.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button11:
                        bt4 = true;
                        DialogFragment singleChoiseDialog4 = new Comptask5SingleChoiceDialog();
                        singleChoiseDialog4.setCancelable(false);
                        singleChoiseDialog4.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button12:
                        bt5 = true;
                        DialogFragment singleChoiseDialog5 = new Comptask5SingleChoiceDialog();
                        singleChoiseDialog5.setCancelable(false);
                        singleChoiseDialog5.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button6:
                        bt6 = true;
                        DialogFragment singleChoiseDialog6 = new Comptask5SingleChoiceDialog();
                        singleChoiseDialog6.setCancelable(false);
                        singleChoiseDialog6.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button7:
                        bt7 = true;
                        DialogFragment singleChoiseDialog7 = new Comptask5SingleChoiceDialog();
                        singleChoiseDialog7.setCancelable(false);
                        singleChoiseDialog7.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;
                    case R.id.algTask2Button8:
                        bt8 = true;
                        DialogFragment singleChoiseDialog8 = new Comptask5SingleChoiceDialog();
                        singleChoiseDialog8.setCancelable(false);
                        singleChoiseDialog8.show(getSupportFragmentManager(), "Single choice Dialog");
                        break;

                    case R.id.algCheck:
                        // проверка на заполнение полей с ответами
                        if (TextUtils.isEmpty(answer1)) {
                            Toast toast = Toast.makeText(Zadcomp5.this, "вы не дали ответ в  поле 1", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }

                        if (TextUtils.isEmpty(answer2)) {
                            Toast toast = Toast.makeText(Zadcomp5.this, "вы не дали ответ в  поле 2", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer3)) {
                            Toast toast = Toast.makeText(Zadcomp5.this, "вы не дали ответ в  поле 3", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer4)) {
                            Toast toast = Toast.makeText(Zadcomp5.this, "вы не дали ответ в  поле 4", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer5)) {
                            Toast toast = Toast.makeText(Zadcomp5.this, "вы не дали ответ в  поле 5", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer6)) {
                            Toast toast = Toast.makeText(Zadcomp5.this, "вы не дали ответ в  поле 6", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer7)) {
                            Toast toast = Toast.makeText(Zadcomp5.this, "вы не дали ответ в  поле 7", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(answer8)) {
                            Toast toast = Toast.makeText(Zadcomp5.this, "вы не дали ответ в  поле 8", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }


                        String markSTR;
                        if (answer1.equalsIgnoreCase("Монитор")) {
                            //если ответ в поле 1 совпал с правильным ответом то делаем +20 баллов
                            mark += 12;

                        }
                        if (answer2.equalsIgnoreCase("Клавиатура")) {
                            //если ответ в поле 2 совпал с правильным ответом то делаем +20 баллов
                            mark += 12;
                        }
                        if (answer3.equalsIgnoreCase("Мышь")) {
                            //если ответ в поле 3 совпал с правильным ответом то делаем +20 баллов
                            mark += 12;
                        }
                        if (answer4.equalsIgnoreCase("Колонки")) {
                            //если ответ в поле 3 совпал с правильным ответом то делаем +20 баллов
                            mark += 12;
                        }
                        if (answer5.equalsIgnoreCase("Микрофон")) {
                            //если ответ в поле 3 совпал с правильным ответом то делаем +20 баллов
                            mark += 12;
                        }
                        if (answer6.equalsIgnoreCase("Web-камера")) {
                            //если ответ в поле 3 совпал с правильным ответом то делаем +20 баллов
                            mark += 12;
                        }
                        if (answer7.equalsIgnoreCase("Флешка")) {
                            //если ответ в поле 3 совпал с правильным ответом то делаем +20 баллов
                            mark += 12;
                        }
                        if (answer8.equalsIgnoreCase("Кард-ридер")) {
                            //если ответ в поле 3 совпал с правильным ответом то делаем +20 баллов
                            mark += 12;
                        }
                        if (mark == 96)
                            mark += 4;

                        //вызов диалогового окна с показом количества баллов
                        if (mark > 50) {
                            dialog = new Dialog(Zadcomp5.this);
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
                                    Intent intent = new Intent(Zadcomp5.this, Computer_Home.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark < 50) {
                            dialog = new Dialog(Zadcomp5.this);
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
                                    Intent intent = new Intent(Zadcomp5.this, Computer_Home.class);
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
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
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
        if (bt6 == true) {
            button6.setText(list[position]);
            answer6 = list[position];
            bt6 = false;
        }
        if (bt7 == true) {
            button7.setText(list[position]);
            answer7 = list[position];
            bt7 = false;
        }
        if (bt8 == true) {
            button8.setText(list[position]);
            answer8 = list[position];
            bt8 = false;
        }
    }

    @Override
    public void onNegativeButtonClicked() {

    }
}
