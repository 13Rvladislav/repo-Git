package com.example.itcity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;

import com.example.itcity.models.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityRegistration extends AppCompatActivity {
    Button btnRegistration;//кнопка зарегестрироваться
    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;
    //объявление полей ввода
    EditText email;
    EditText name;
    EditText password1;
    EditText password2;

    //обработка нажатия клавиши зарегистрироваться
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //поля ввода
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.UserName);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);

        auth = FirebaseAuth.getInstance();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        btnRegistration = (Button) findViewById(R.id.REGISTRATION);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.REGISTRATION:
                        if (TextUtils.isEmpty(email.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "Поле 'email' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(name.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "Поле 'имя пользователя' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(password1.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "Поле 'пароль' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(password2.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "Поле 'повторить пароль' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (password1.getText().toString().length() < 5) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "слишком короткий пароль", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        String pass1 = password1.getText().toString();
                        String pass2 = password2.getText().toString();
                        boolean passcorrect = pass1.equalsIgnoreCase(pass2);
                        if (!passcorrect) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "пароли не совпадают", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }

                        //регистрация пользователя
                        auth.createUserWithEmailAndPassword(email.getText().toString(), password1.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                User user = new User();
                                user.setEmail(email.getText().toString());
                                user.setName(name.getText().toString());
                                String pass1 = password1.getText().toString();
                                int pass3 = pass1.hashCode();

                                user.setPass(pass3);

                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {

                                                Toast toast = Toast.makeText(ActivityRegistration.this, "Пользователь успешно зарегистрирован!", Toast.LENGTH_SHORT);
                                                toast.show();
                                                Intent intent = new Intent(ActivityRegistration.this, ActivityAuthor.class);
                                                startActivity(intent);
                                            }
                                        });
                            }
                        });


                }
            }
        };

        btnRegistration.setOnClickListener(onClickListener);


    }
}