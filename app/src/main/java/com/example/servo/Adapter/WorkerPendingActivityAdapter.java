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
import com.example.servo.WorkerPendingActivity;
import com.example.servo.WorkerPendingInfo;

import java.util.ArrayList;

public class WorkerPendingActivityAdapter extends RecyclerView.Adapter<WorkerPendingActivityAdapter.WorkerPendingActivityHolder> {


    private Context context;
    private ArrayList<WorkerPendingInfo> workerPendingInfos;

    public WorkerPendingActivityAdapter(Context context, ArrayList<WorkerPendingInfo> workerPendingInfos) {
        this.context = context;
        this.workerPendingInfos = workerPendingInfos;
    }

    @NonNull
    @Override
    public WorkerPendingActivityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pending_worker_card_layout, parent, false);
        return new WorkerPendingActivityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkerPendingActivityHolder holder, int position) {
        WorkerPendingInfo workerPendingInfo = workerPendingInfos.get(position);
        holder.SetDetails(workerPendingInfo);
    }

    @Override
    public int getItemCount() {
        return workerPendingInfos.size();
    }


    public class WorkerPendingActivityHolder extends RecyclerView.ViewHolder {

        private TextView txtWIdNo, txtWType, txtWDate, txtWTime, txtWRoom, txtWRoll, txtWContact;
        public WorkerPendingActivityHolder(@NonNull View itemView) {
            super(itemView);
            txtWIdNo = itemView.findViewById(R.id.pwIdNo);
            txtWType = itemView.findViewById(R.id.pwType);
            txtWDate = itemView.findViewById(R.id.pwDate);
            txtWTime = itemView.findViewById(R.id.pwTime);
            txtWRoom = itemView.findViewById(R.id.pwRoomNo);
            txtWRoll = itemView.findViewById(R.id.pwRollNo);
            txtWContact = itemView.findViewById(R.id.pwContactNo);
        }

        @SuppressLint("SetTextI18n")
        void SetDetails(WorkerPendingInfo workerPendingInfo) {
            txtWIdNo.setText("NO : " + workerPendingInfo.getIdNo());
            txtWType.setText("TYPE : " + workerPendingInfo.getType());
            txtWRoom.setText("ROOM NO : " + workerPendingInfo.getRoomNO());
            txtWRoll.setText("ROLL NO : " + workerPendingInfo.getRollNO());
            txtWContact.setText("CONTACT NO : " + workerPendingInfo.getContactNo());
            txtWDate.setText("DATE : " + workerPendingInfo.getDate());
            txtWTime.setText("TIME : " + workerPendingInfo.getTime());
        }
    }
}
