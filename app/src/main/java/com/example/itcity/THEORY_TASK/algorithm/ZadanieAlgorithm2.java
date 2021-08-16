package com.example.itcity.THEORY_TASK.algorithm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.itcity.R;

public class ZadanieAlgorithm2 extends AppCompatActivity implements  SingleChoiceDialogFragment.SingleChoiceListener {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtask2);
        button1 = (Button) findViewById(R.id.algTask2Button1);
        button2 = (Button) findViewById(R.id.algTask2Button2);
        button3 = (Button) findViewById(R.id.algTask2Button3);
        button4 = (Button) findViewById(R.id.algTask2Button4);
        button5 = (Button) findViewById(R.id.algTask2Button5);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.algTask2Button1:
                        DialogFragment singleChoiseDialog=new SingleChoiceDialogFragment();
                        singleChoiseDialog.setCancelable(false);
                        singleChoiseDialog.show(getSupportFragmentManager(),"Single choice Dialog");
                        break;
                    case R.id.algTask2Button2:

                        break;
                    case R.id.algTask2Button3:

                        break;
                    case R.id.algTask2Button4:

                        break;
                    case R.id.algTask2Button5:
                        break;

                }
            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);


    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        if(position==0)
    button1.setText(list[position]);
        if(position==1)
            button2.setText(list[position]);
        if(position==2)
            button3.setText(list[position]);
        if(position==3)
            button4.setText(list[position]);
        if(position==4)
            button5.setText(list[position]);
    }

    @Override
    public void onNegativeButtonClicked() {
button1.setText("Dialog");
    }
}