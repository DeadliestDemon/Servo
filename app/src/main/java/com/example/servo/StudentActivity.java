package com.example.servo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
    private Fragment selectorFragment;

    FloatingActionButton floatingActionButton;

    public static ArrayList<Integer> time = new ArrayList<>();
    public static ArrayList<Integer> date = new ArrayList<>();
    public static ArrayList<String> uid = new ArrayList<>();
    public static ArrayList<String> type = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        floatingActionButton = findViewById(R.id.fab);

//        time = new ArrayList<>();
//        date = new ArrayList<>();
//        uid = new ArrayList<>();
//        type = new ArrayList<>();


        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch(item.getItemId())
//                {
//                    case R.id.nav_pending:
//                selectorFragment = new PendingFragment();
//                break;
//
//                    case R.id.nav_completed:
//                selectorFragment = new CompletedFragment();
//                break;
//                }
//                if (selectorFragment != null)
//                {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectorFragment).commit();
//                }
//
//                return true;
//
//
//            }
//        });
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PendingFragment()).commit();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentActivity.this, ComplaintActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));

            }
        });

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






    }


}