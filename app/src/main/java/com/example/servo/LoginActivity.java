package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText LogUser;
    EditText LogPass;

    Button loginButton;

    TextView notuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LogUser = findViewById(R.id.logUser);
        LogPass = findViewById(R.id.logPass);

        loginButton = findViewById(R.id.loginBtn);

        notuser = findViewById(R.id.notAuser);

        notuser.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                notuser.setTextColor(R.color.colorPrimary);
                notuser.setTypeface(Typeface.DEFAULT_BOLD);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = LogUser.getText().toString();
                String pass = LogPass.getText().toString();

                if (user.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill username", Toast.LENGTH_SHORT).show();
                } else if (pass.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill password", Toast.LENGTH_SHORT).show();
                } else {
                    // if is successful
                    Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }
}