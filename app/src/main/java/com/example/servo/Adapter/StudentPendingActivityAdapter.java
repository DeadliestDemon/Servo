package com.example.servo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servo.R;
import com.example.servo.StudentPendingInfo;

import java.util.ArrayList;

public class StudentPendingActivityAdapter extends RecyclerView.Adapter<StudentPendingActivityAdapter.StudentPendingActivityHolder> {
//    Adapter

    private Context context;
    private ArrayList<StudentPendingInfo> studentPendingInfos;

    public StudentPendingActivityAdapter(Context context, ArrayList<StudentPendingInfo> studentPendingInfos) {
        this.context = context;
        this.studentPendingInfos = studentPendingInfos;
    }

    @NonNull
    @Override
    public StudentPendingActivityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pending_student_card_layout, parent, false);
        return new StudentPendingActivityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentPendingActivityAdapter.StudentPendingActivityHolder holder, int position) {
        StudentPendingInfo studentPendingInfo = studentPendingInfos.get(position);
        holder.SetDetails(studentPendingInfo);
    }

    @Override
    public int getItemCount() {
        return studentPendingInfos.size();
    }


    //    Holder

    public class StudentPendingActivityHolder extends RecyclerView.ViewHolder {

        private TextView txtIdNo, txtType, txtDate, txtTime;
        public StudentPendingActivityHolder(@NonNull View itemView) {
            super(itemView);
            txtIdNo = itemView.findViewById(R.id.txtIdNo);
            txtType = itemView.findViewById(R.id.txtType);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtTime = itemView.findViewById(R.id.txtTime);
        }

        @SuppressLint("SetTextI18n")
        void SetDetails(StudentPendingInfo studentPendingInfo) {
            txtIdNo.setText("NO : " + studentPendingInfo.getIdNo());
            txtType.setText("TYPE : " + studentPendingInfo.getType());
            txtDate.setText("DATE : " + studentPendingInfo.getDate());
            txtTime.setText("TIME : " + studentPendingInfo.getTime());
        }
    }




}
