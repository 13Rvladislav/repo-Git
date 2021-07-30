package com.example.itcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityAuthor extends AppCompatActivity {
    Button buttonreggistration;
    Button buttonautirisation;
    Button buttonmisspassword;

    EditText email;
    EditText password;

    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана

        buttonmisspassword = (Button) findViewById(R.id.misspassword);
        buttonreggistration = (Button) findViewById(R.id.buttonReg);
        buttonautirisation = (Button) findViewById(R.id.buttonVosstanov);


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.Password);

        auth = FirebaseAuth.getInstance();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");

        View.OnClickListener onClickListener = new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonReg: {
                        Intent intent = new Intent(ActivityAuthor.this, ActivityRegistration.class);
                        startActivity(intent);
                        break;
                    }

                    case R.id.misspassword: {
                        Intent intent = new Intent(ActivityAuthor.this, EkranVosstanovleniyaActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case R.id.buttonVosstanov:
                        if (TextUtils.isEmpty(email.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityAuthor.this, "Поле 'email' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }

                        if (TextUtils.isEmpty(password.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityAuthor.this, "Поле 'пароль' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;

                        }
                        auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Intent intent = new Intent(ActivityAuthor.this, ActivityMap.class);
                                        startActivity(intent);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast toast = Toast.makeText(ActivityAuthor.this, "Ошибка авторизации" + e.getMessage(), Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });

                }
            }
        };
        buttonautirisation.setOnClickListener(onClickListener);
        buttonreggistration.setOnClickListener(onClickListener);
        buttonmisspassword.setOnClickListener(onClickListener);
    }
}

