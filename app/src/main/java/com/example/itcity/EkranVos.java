package com.example.itcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class EkranVos extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText email;
    Button btnvost;

    public void sendPasswordReset() {
        // [START send_password_reset]
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = "user@example.com";

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Email sent.");
                        }
                    }
                });
        // [END send_password_reset]
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ekran_vosstanovleniya);
        email = (EditText) findViewById(R.id.email);
        btnvost = (Button) findViewById(R.id.buttonVosstanov);
        //обработка клавиш кнопок
        View.OnClickListener onClickListener = new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonVosstanov:
                        sendPasswordReset();
                        Intent intent = new Intent(EkranVos.this, ActivityAuthor.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        };

        btnvost.setOnClickListener(onClickListener);

    }
}