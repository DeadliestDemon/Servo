package com.example.servo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;


    FloatingActionButton floatingActionButton;
    Button Pending;
    Button Completed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        floatingActionButton = findViewById(R.id.fab);
        Pending = findViewById(R.id.pendingBtn);
        Completed = findViewById(R.id.completedBtn);



        Pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, PendingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));

            }
        });

        Completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, CompletedActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));

            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, ComplaintActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));

            }
        });








    }


}