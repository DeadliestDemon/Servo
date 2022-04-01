package com.example.servo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.servo.Adapter.PendingRecyclerViewAdapter;
import com.example.servo.Models.NewComplaint;

import java.util.ArrayList;

public class StudentPendingActivity extends AppCompatActivity {

    public static ArrayList<Integer> time = new ArrayList<>();
    public static ArrayList<Integer> date = new ArrayList<>();
    public static ArrayList<String> uid = new ArrayList<>();
    public static ArrayList<String> type = new ArrayList<>();

    private ArrayList<NewComplaint> complaints;
    private ArrayList<NewComplaint> completedComplaints;

    private RecyclerView recyclerView;
    private PendingRecyclerViewAdapter pendingRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        recyclerView = findViewById(R.id.pendingView);
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

        complaints = new ArrayList<NewComplaint>();

        for (int i=0; i<6; i++)
        {
            NewComplaint currComp = new NewComplaint(time.get(i%3),date.get(i%3),type.get(i%3),uid.get(i%3),"asdf","sadfa",2534,515,"ak jdfnksd fiu","957425774","576541353",1800, 23102022);
            complaints.add(currComp);
        }

        pendingRecyclerViewAdapter = new PendingRecyclerViewAdapter(StudentPendingActivity.this, complaints);
        recyclerView.setAdapter(pendingRecyclerViewAdapter);





    }

    public void getData(View v)
    {
        completedComplaints = pendingRecyclerViewAdapter.listOfCompleted();

        for (int i=0; i<completedComplaints.size(); i++)
        {
            NewComplaint tmp = completedComplaints.get(i);

            for (int j = 0;j < complaints.size(); j++)
            {
                if (tmp.getUid() == complaints.get(j).getUid())
                {
                    complaints.remove(j);
//                    break;

                }
            }



        }

        completedComplaints.clear();

        pendingRecyclerViewAdapter.notifyDataSetChanged();


    }

}