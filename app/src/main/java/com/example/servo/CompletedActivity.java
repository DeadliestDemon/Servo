package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.servo.Adapter.CompletedRecyclerViewAdapter;

import java.util.ArrayList;

public class CompletedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CompletedRecyclerViewAdapter completedRecyclerViewAdapter;
    private ArrayList<newComplaint> copletedComplaints;

    public static ArrayList<String> type = new ArrayList<>();
    public static ArrayList<Integer> time = new ArrayList<>();
    public static ArrayList<Integer> date = new ArrayList<>();
    public static ArrayList<String> uid = new ArrayList<>();

    public static ArrayList<Integer> completedtime = new ArrayList<>();
    public static ArrayList<Integer> completeddate = new ArrayList<>();









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed);

        recyclerView = findViewById(R.id.completedRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        time.add(2300);
        time.add(2340);
        time.add(2200);

        date.add(25122022);
        date.add(25122022);
        date.add(25122022);

        uid.add("2565");
        uid.add("2545");
        uid.add("2625");

        type.add("Electrician");
        type.add("Carpenter");
        type.add("Cleaner");

        completedtime.add(2200);
        completedtime.add(1800);
        completedtime.add(1400);

        completeddate.add(26112022);
        completeddate.add(22112022);
        completeddate.add(24112022);

        copletedComplaints = new ArrayList<newComplaint>();

        for (int i=0; i<6; i++)
        {
            newComplaint currComp = new newComplaint(time.get(i%3),date.get(i%3),type.get(i%3),uid.get(i%3),"asdf","sadfa",2534,515,"ak jdfnksd fiu","957425774","576541353",completedtime.get(i%3),completeddate.get(i%3));
            copletedComplaints.add(currComp);
        }

        completedRecyclerViewAdapter = new CompletedRecyclerViewAdapter(CompletedActivity.this, copletedComplaints);
        recyclerView.setAdapter(completedRecyclerViewAdapter);




    }
}