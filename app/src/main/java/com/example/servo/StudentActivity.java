package com.example.servo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.servo.Adapter.CompletedActivityAdapter;
import com.example.servo.Adapter.StudentPendingActivityAdapter;
import com.example.servo.Api.NewComplaint;
import com.example.servo.Api.NewWorkerUser;
import com.example.servo.Api.RetrofitClient;
import com.example.servo.Models.NewUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    String Token;
    String Phone;

    ArrayList<NewComplaint> newUser;

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

        Token = getIntent().getStringExtra("token");
        Phone = getIntent().getStringExtra("phone");

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.servo", Context.MODE_PRIVATE);
        completedActivityAdapter.notifyDataSetChanged();

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
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(StudentActivity.this, ComplaintActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                Intent intent = new Intent(StudentActivity.this, ComplaintActivity.class);
                intent.putExtra("token",Token);
                intent.putExtra("phone", Phone);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                completedActivityAdapter.notifyDataSetChanged();



            }

        });
    }
    public void onCheckboxClicked(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Confirm Exit..!!!");
        // Icon Of Alert Dialog
        alertDialogBuilder.setIcon(R.drawable.ic_deplete_complaint_alert);
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Are you sure,You want to delete this complaint?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(StudentActivity.this,"You clicked over No",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void createCompletedListData() {

        Call<ArrayList<NewComplaint>> callDone = RetrofitClient
                .getInstance()
                .getApi()
                .getDone(Token);

        callDone.enqueue(new Callback<ArrayList<NewComplaint>>() {
            @Override
            public void onResponse(Call<ArrayList<NewComplaint>> call, Response<ArrayList<NewComplaint>> response) {
                if(response.code() == 200)
                {

                    newUser = response.body();
//                    if (newUser != null)
//                    {
//                        Log.i("size: ", Integer.toString(newUser.size()));
//
//                    }
//                    Toast.makeText(StudentActivity.this, newUser.size(), Toast.LENGTH_SHORT).show();

//                    int id = newUser.getId();
//                    token = newUser.getToken();

                    if (newUser != null)
                    {
                        for (int i=0; i< newUser.size(); i++)
                        {
                            int id = newUser.get(i).getId();
                            String type = newUser.get(i).getType();
                            String DateLog = newUser.get(i).getDate_lodged();
                            String date = DateLog.substring(0,10);
                            String time = DateLog.substring(11,16);
                            CompletedActivityInfo completedActivityInfo = new CompletedActivityInfo(Integer.toString(id), type, date, time, "1/4/2022", "5:10 PM");
                            completedActivityInfos.add(completedActivityInfo);



                        }
                    }


                    completedActivityAdapter.notifyDataSetChanged();


                }
                else
                {
                    String s = response.errorBody().toString();
                    Toast.makeText(StudentActivity.this, s, Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<NewComplaint>> call, Throwable t) {

            }
        });

        if (newUser != null)
        {

        }



//        CompletedActivityInfo completedActivityInfo = new CompletedActivityInfo("4827890", "casfdwadf", "1/4/2022", "5:10 PM", "1/4/2022", "5:10 PM");
//        CompletedActivityInfo completedActivityInfo1 = new CompletedActivityInfo("4827890", "casfdwadf", "1/4/2022", "5:10 PM", "1/4/2022", "5:10 PM");
//        completedActivityInfos.add(completedActivityInfo);
//        completedActivityInfos.add(completedActivityInfo1);
    }

    private void createStudentPendingListData() {

        Call<ArrayList<NewComplaint>> callPending = RetrofitClient
                .getInstance()
                .getApi()
                .getPending(Token);

        callPending.enqueue(new Callback<ArrayList<NewComplaint>>() {
            @Override
            public void onResponse(Call<ArrayList<NewComplaint>> call, Response<ArrayList<NewComplaint>> response) {
                if(response.code() == 200)
                {

                    newUser = response.body();
//                    if(newUser != null){
//                        Log.i("size: ", Integer.toString(newUser.size()));
//
//                    }
//                    Toast.makeText(StudentActivity.this, newUser.size(), Toast.LENGTH_SHORT).show();

//                    int id = newUser.getId(); asdf@1234
//                    token = newUser.getToken(); student1

                    if (newUser != null)
                    {
                        for (int i=0; i< newUser.size(); i++)
                        {
                            int id = newUser.get(i).getId();
                            String type = newUser.get(i).getType();
                            String DateLog = newUser.get(i).getDate_lodged();
                            String date = DateLog.substring(0,10);
                            String time = DateLog.substring(11,16);
                            StudentPendingInfo studentPendingInfo = new StudentPendingInfo(Integer.toString(id), type, date, time);
                            studentPendingInfos.add(studentPendingInfo);



                        }
                    }


                    studentPendingActivityAdapter.notifyDataSetChanged();

                }
                else
                {
                    String s = response.errorBody().toString();
                    Toast.makeText(StudentActivity.this, s, Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<NewComplaint>> call, Throwable t) {

            }
        });




//        StudentPendingInfo studentPendingInfo1 = new StudentPendingInfo("1234", "ELECTRICIAN", "1/4/2022", "5:10 PM");
//        studentPendingInfos.add(studentPendingInfo);
//        studentPendingInfos.add(studentPendingInfo1);
    }
}