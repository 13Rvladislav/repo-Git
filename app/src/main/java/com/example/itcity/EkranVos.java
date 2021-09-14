package com.example.itcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class EkranVos extends AppCompatActivity {

    EditText userEmail;
    Button btnvost;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ekran_vosstanovleniya);
        getSupportActionBar().hide();
        userEmail = (EditText) findViewById(R.id.email);
        btnvost = (Button) findViewById(R.id.buttonVosstanov);

        firebaseAuth = FirebaseAuth.getInstance();
        //обработка клавиш кнопок
        View.OnClickListener onClickListener = new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonVosstanov:
                        firebaseAuth.sendPasswordResetEmail(userEmail.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>()
                                {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task)
                                    {
                                        if (task.isSuccessful())
                                        {
                                            Toast.makeText(EkranVos.this,
                                                    "письмо для сброса пароля отправлено на ваш электронный адрес", Toast.LENGTH_LONG).show();
                                        }
                                        else
                                            {
                                                Toast.makeText(EkranVos.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                            }
                                    }
                                });

                        break;

                    default:
                        break;
                }
            }
        };

        btnvost.setOnClickListener(onClickListener);

    }
}