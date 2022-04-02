package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servo.Adapter.CompletedActivityAdapter;
import com.example.servo.Adapter.StudentPendingActivityAdapter;
import com.example.servo.Adapter.WorkerPendingActivityAdapter;

import java.util.ArrayList;

public class WorkerActivity extends AppCompatActivity {

    RecyclerView workerPendingActivityRecyclerView;
    RecyclerView completedActivityRecyclerView;
    private CompletedActivityAdapter completedActivityAdapter;
    private ArrayList<CompletedActivityInfo> completedActivityInfos;
    private WorkerPendingActivityAdapter workerPendingActivityAdapter;
    private ArrayList<WorkerPendingInfo> workerPendingInfos;
    Button pendingWorker;
    Button completedWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);

        pendingWorker = findViewById(R.id.pendingBtnWorker);
        completedWorker = findViewById(R.id.completedBtnWorker);
        workerPendingActivityRecyclerView = findViewById(R.id.workerPendingRecyclerView);
        completedActivityRecyclerView = findViewById(R.id.workerCompletedRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        workerPendingActivityRecyclerView.setLayoutManager(linearLayoutManager);
        workerPendingInfos = new ArrayList<WorkerPendingInfo>();
        workerPendingActivityAdapter = new WorkerPendingActivityAdapter(this, workerPendingInfos);
        workerPendingActivityRecyclerView.setAdapter(workerPendingActivityAdapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        completedActivityRecyclerView.setLayoutManager(linearLayoutManager1);
        completedActivityInfos = new ArrayList<CompletedActivityInfo>();
        completedActivityAdapter = new CompletedActivityAdapter(this, completedActivityInfos);
        completedActivityRecyclerView.setAdapter(completedActivityAdapter);

        createCompletedListData();
        createStudentPendingListData();
        pendingWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pendingWorker.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.colorPrimary)));
                completedWorker.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.white)));
                pendingWorker.setTextColor(getColor(R.color.white));
                completedWorker.setTextColor(getColor(R.color.colorPrimary));
                workerPendingActivityRecyclerView.setVisibility(View.VISIBLE);
                completedActivityRecyclerView.setVisibility(View.INVISIBLE);
            }
        });

        completedWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                completedWorker.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.colorPrimary)));
                pendingWorker.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.white)));
                completedWorker.setTextColor(getColor(R.color.white));
                pendingWorker.setTextColor(getColor(R.color.colorPrimary));
                workerPendingActivityRecyclerView.setVisibility(View.INVISIBLE);
                completedActivityRecyclerView.setVisibility(View.VISIBLE);
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
        WorkerPendingInfo workerPendingInfo = new WorkerPendingInfo("1234", "ELECTRICIAN", "1/4/2022", "5:10 PM", "5607", "IEC2020080", "9761319703");
        WorkerPendingInfo workerPendingInfo1 = new WorkerPendingInfo("1234", "ELECTRICIAN", "1/4/2022", "5:10 PM", "5607", "IEC2020080", "9761319703");
        workerPendingInfos.add(workerPendingInfo);
        workerPendingInfos.add(workerPendingInfo1);
    }
}