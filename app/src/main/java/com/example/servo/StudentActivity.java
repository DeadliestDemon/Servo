package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.servo.Adapter.CompletedActivityAdapter;
import com.example.servo.Adapter.StudentPendingActivityAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    RecyclerView studentPendingActivityRecyclerView;
    RecyclerView completedActivityRecyclerView;
    private CompletedActivityAdapter completedActivityAdapter;
    private ArrayList<CompletedActivityInfo> completedActivityInfos;
    private StudentPendingActivityAdapter studentPendingActivityAdapter;
    private ArrayList<StudentPendingInfo> studentPendingInfos;
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
        studentPendingActivityRecyclerView = findViewById(R.id.studentPendingRecyclerView);
        completedActivityRecyclerView = findViewById(R.id.completedRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        studentPendingActivityRecyclerView.setLayoutManager(linearLayoutManager);
        studentPendingInfos = new ArrayList<StudentPendingInfo>();
        studentPendingActivityAdapter = new StudentPendingActivityAdapter(this, studentPendingInfos);
        studentPendingActivityRecyclerView.setAdapter(studentPendingActivityAdapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        completedActivityRecyclerView.setLayoutManager(linearLayoutManager1);
        completedActivityInfos = new ArrayList<CompletedActivityInfo>();
        completedActivityAdapter = new CompletedActivityAdapter(this, completedActivityInfos);
        completedActivityRecyclerView.setAdapter(completedActivityAdapter);

        createCompletedListData();
        createStudentPendingListData();
        Pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pending.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.colorPrimary)));
                Completed.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.white)));
                Pending.setTextColor(getColor(R.color.white));
                Completed.setTextColor(getColor(R.color.colorPrimary));
                studentPendingActivityRecyclerView.setVisibility(View.VISIBLE);
                completedActivityRecyclerView.setVisibility(View.INVISIBLE);
            }
        });

        Completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Completed.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.colorPrimary)));
                Pending.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.white)));
                Completed.setTextColor(getColor(R.color.white));
                Pending.setTextColor(getColor(R.color.colorPrimary));
                studentPendingActivityRecyclerView.setVisibility(View.INVISIBLE);
                completedActivityRecyclerView.setVisibility(View.VISIBLE);
            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, ComplaintActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
            }
        });
    }

    private void createCompletedListData() {
        CompletedActivityInfo completedActivityInfo = new CompletedActivityInfo("4827890", "casfdwadf", "1/4/2022", "5:10 PM", "1/4/2022", "5:10 PM");
        CompletedActivityInfo completedActivityInfo1 = new CompletedActivityInfo("4827890", "casfdwadf", "1/4/2022", "5:10 PM", "1/4/2022", "5:10 PM");
        completedActivityInfos.add(completedActivityInfo);
        completedActivityInfos.add(completedActivityInfo1);
    }

    private void createStudentPendingListData() {
        StudentPendingInfo studentPendingInfo = new StudentPendingInfo("1234", "ELECTRICIAN", "1/4/2022", "5:10 PM");
        StudentPendingInfo studentPendingInfo1 = new StudentPendingInfo("1234", "ELECTRICIAN", "1/4/2022", "5:10 PM");
        studentPendingInfos.add(studentPendingInfo);
        studentPendingInfos.add(studentPendingInfo1);
    }
}