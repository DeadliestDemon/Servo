package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    EditText Username;
    EditText Email;
    EditText Password;
    EditText Phoneno;

    RadioGroup radioGrp;
    RadioButton buttonSel;

    Spinner spinner;

    TextView alreadyUser;

    EditText Rollno;
    EditText Roomno;

    Button registerButton;

    String proffes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Phoneno = findViewById(R.id.phoneno);

        Rollno = findViewById(R.id.rollno);
        Roomno = findViewById(R.id.roomno);

        spinner = findViewById(R.id.profession);

        alreadyUser = findViewById(R.id.alreadyAuser);

        registerButton = findViewById(R.id.newRegister);

        radioGrp = findViewById(R.id.radioGroup);
        radioGrp.setOnCheckedChangeListener(this);

        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Profession, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGrp.getCheckedRadioButtonId() == R.id.buttonStudent)
                {
                    registerStudent();
                }
                else
                {
                    registerWorker();
                }
            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i)
        {
            case R.id.buttonStudent:

                Roomno.setVisibility(View.VISIBLE);
                Rollno.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.INVISIBLE);

                break;

            case R.id.buttonWorker:

                spinner.setVisibility(View.VISIBLE);
                Roomno.setVisibility(View.INVISIBLE);
                Rollno.setVisibility(View.INVISIBLE);

                break;
        }

    }

    public void registerStudent()
    {
        String user = Username.getText().toString();
        String mail = Email.getText().toString();
        String pass = Password.getText().toString();
        String phone = Phoneno.getText().toString();
        String roll = Rollno.getText().toString();
        String room = Roomno.getText().toString();

        // add student

        if (user.isEmpty())
        {
            Toast.makeText(this, "Please fill username", Toast.LENGTH_SHORT).show();
        }
        else if (mail.isEmpty())
        {
            Toast.makeText(this, "Please fill email", Toast.LENGTH_SHORT).show();

        }
        else if (pass.isEmpty())
        {
            Toast.makeText(this, "Please fill password", Toast.LENGTH_SHORT).show();

        }
        else if (phone.isEmpty())
        {
            Toast.makeText(this, "Please fill phone", Toast.LENGTH_SHORT).show();

        }
        else if (roll.isEmpty())
        {
            Toast.makeText(this, "Please fill roll number", Toast.LENGTH_SHORT).show();

        }
        else if (room.isEmpty())
        {
            Toast.makeText(this, "Please fill room number", Toast.LENGTH_SHORT).show();

        }
        else
        {
            // if is successful
            Intent intent = new Intent(RegisterActivity.this, StudentActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }





    }

    public void registerWorker()
    {
        String user = Username.getText().toString();
        String mail = Email.getText().toString();
        String pass = Password.getText().toString();
        String phone = Phoneno.getText().toString();

        // add worker

        if(user.isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "Please fill username", Toast.LENGTH_SHORT).show();

        }
        else if (mail.isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "Please fill email", Toast.LENGTH_SHORT).show();

        }
        else if (pass.isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "Please fill password", Toast.LENGTH_SHORT).show();

        }
        else if (phone.isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "Please fill phone number", Toast.LENGTH_SHORT).show();

        }
        else if (proffes.isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "Please fill proffesion", Toast.LENGTH_SHORT).show();

        }
        else
        {
            // if it successful
            Intent intent = new Intent(RegisterActivity.this, WorkerActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }

    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        proffes = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}