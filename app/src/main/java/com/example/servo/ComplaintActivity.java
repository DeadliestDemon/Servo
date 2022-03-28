package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ComplaintActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner Reqperson;
    EditText description;
    Button addComplaint;

    String reqProff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        Reqperson = findViewById(R.id.reqPerson);
        description = findViewById(R.id.complaintDesc);
        addComplaint = findViewById(R.id.newComplaintBtn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Profession, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Reqperson.setAdapter(adapter);
        Reqperson.setOnItemSelectedListener(this);

        addComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String desc = description.getText().toString();

                if (desc.isEmpty())
                {
                    Toast.makeText(ComplaintActivity.this, "Please write a small description", Toast.LENGTH_SHORT).show();
                }
                else if(reqProff.isEmpty())
                {
                    Toast.makeText(ComplaintActivity.this, "Please select a required professional", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // register Complaint
                    finish();
                }

            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        reqProff = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}