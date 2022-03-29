package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkerActivity extends AppCompatActivity {

    Button pendingWork;
    Button completedWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);

        pendingWork = findViewById(R.id.workerPendingBtn);
        completedWork = findViewById(R.id.workerCompletedBtn);

        pendingWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkerActivity.this, WorkerPendingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));

            }
        });

        completedWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkerActivity.this, CompletedActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));

            }
        });



    }
}