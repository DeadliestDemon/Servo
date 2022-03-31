package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText Username;
    EditText Email;
    EditText Password;
    EditText PhoneNo;
    Button buttonStudent;
    Button buttonEmployee;
    Boolean isStudent = true;
    Spinner spinner;
    TextView alreadyUser;
    EditText RollNo;
    EditText RoomNo;
    Button registerButton;
    String profession;

    @SuppressLint({"ResourceAsColor", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        PhoneNo = findViewById(R.id.phoneno);
        RollNo = findViewById(R.id.rollNo);
        RoomNo = findViewById(R.id.roomNo);
        spinner = findViewById(R.id.profession);
        alreadyUser = findViewById(R.id.alreadyAUser);
        registerButton = findViewById(R.id.newRegister);
        buttonStudent = findViewById(R.id.buttonStudent);
        buttonEmployee = findViewById(R.id.buttonEmployee);

        alreadyUser.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            alreadyUser.setTextColor(R.color.colorPrimary);
            alreadyUser.setTypeface(Typeface.DEFAULT_BOLD);
        });
        buttonStudent.setOnClickListener(view -> {
            isStudent = true;
            buttonStudent.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DAE9FA")));
            buttonEmployee.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            spinner.setVisibility(View.INVISIBLE);
            RoomNo.setVisibility(View.VISIBLE);
            RollNo.setVisibility(View.VISIBLE);
        });
        buttonEmployee.setOnClickListener(view -> {
            isStudent = false;
            buttonEmployee.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DAE9FA")));
            buttonStudent.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            spinner.setVisibility(View.VISIBLE);
            RoomNo.setVisibility(View.INVISIBLE);
            RollNo.setVisibility(View.INVISIBLE);
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Profession, R.layout.custom_spinner);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);
        registerButton.setOnClickListener(view -> {
            if(isStudent) {
                registerStudent();
            } else {
                registerWorker();
            }
        });
    }

    public void registerStudent() {
        String user = Username.getText().toString();
        String mail = Email.getText().toString();
        String pass = Password.getText().toString();
        String phone = PhoneNo.getText().toString();
        String roll = RollNo.getText().toString();
        String room = RoomNo.getText().toString();

        // add student
        if (user.isEmpty()) {
            Toast.makeText(this, "Please fill username", Toast.LENGTH_SHORT).show();
        } else if (mail.isEmpty()) {
            Toast.makeText(this, "Please fill email", Toast.LENGTH_SHORT).show();
        } else if (pass.isEmpty()) {
            Toast.makeText(this, "Please fill password", Toast.LENGTH_SHORT).show();
        } else if (phone.isEmpty()) {
            Toast.makeText(this, "Please fill phone", Toast.LENGTH_SHORT).show();
        } else if (roll.isEmpty()) {
            Toast.makeText(this, "Please fill roll number", Toast.LENGTH_SHORT).show();
        } else if (room.isEmpty()) {
            Toast.makeText(this, "Please fill room number", Toast.LENGTH_SHORT).show();
        } else {
            // if is successful
            Intent intent = new Intent(RegisterActivity.this, StudentActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    public void registerWorker() {
        String user = Username.getText().toString();
        String mail = Email.getText().toString();
        String pass = Password.getText().toString();
        String phone = PhoneNo.getText().toString();

        // add worker
        if(user.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Please fill username", Toast.LENGTH_SHORT).show();
        } else if (mail.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Please fill email", Toast.LENGTH_SHORT).show();
        } else if (pass.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Please fill password", Toast.LENGTH_SHORT).show();
        } else if (phone.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Please fill phone number", Toast.LENGTH_SHORT).show();
        } else if (profession.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Please fill profession", Toast.LENGTH_SHORT).show();
        } else {
            // if it successful
            Intent intent = new Intent(RegisterActivity.this, WorkerActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        profession = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }
}