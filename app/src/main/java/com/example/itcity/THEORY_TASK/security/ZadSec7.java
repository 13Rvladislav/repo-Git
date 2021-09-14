package com.example.itcity.THEORY_TASK.security;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itcity.ActivityAuthor;
import com.example.itcity.R;

public class ZadSec7 extends AppCompatActivity {
    Dialog dialog;//диалоговое окно
    Button check;//кнопка продолжить
    Button back;
    Button enterword;
    int mark;//пременная ,где будут храниться баллы и пердавться в следющее активити для просмтора результат и после записываться в firebase
    String all = "вирусчервьхакертроянпрограммахакер";
    EditText answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectask7);
        getSupportActionBar().hide();
        check = findViewById(R.id.continueSec);
        answered = findViewById(R.id.answer);
        enterword = findViewById(R.id.enter_a_word);
        back= (Button) findViewById(R.id.bottomSecurityK);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bottomSecurityK:
                        Intent intent = new Intent(ZadSec7.this, TheorySecurity7.class);
                        startActivity(intent);
                        break;
                    case R.id.enter_a_word:
                        String ans = answered.getText().toString();
                        ans= ans.toLowerCase();
                        int indexM = all.indexOf(ans);
                        if (indexM != -1) {
                            mark += 20;
                            all = all.replace(ans, "");
                            Toast toast = Toast.makeText(ZadSec7.this, "Поздравляем!!! одно из слов было найдено", Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            Toast toast = Toast.makeText(ZadSec7.this, "Неверное слово!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        answered.setText("");
                        break;
                    case R.id.continueSec:
                        String markSTR;
                        //вызов диалогового окна с показом количества баллов
                        if (mark>=20) {
                            dialog = new Dialog(ZadSec7.this);
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
                                    Intent intent = new Intent(ZadSec7.this, Security_HOME.class);
                                    startActivity(intent);
                                }
                            });
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                            break;
                        }
                        if (mark<20) {
                            dialog = new Dialog(ZadSec7.this);
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
                                    Intent intent = new Intent(ZadSec7.this, Security_HOME.class);
                                    startActivity(intent);
                                }
                            });
                            break;
                            //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА НЕ МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ УРОВЕНЬ НЕ МЕНЯЕМ;
                        }

                }
            }
        };
        enterword.setOnClickListener(onClickListener);
        check.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }
}
