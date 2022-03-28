package com.example.servo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class pendingAdapter extends ArrayAdapter {

    ArrayList<Integer> time;
    ArrayList<Integer> date;
    ArrayList<String> uid;
    ArrayList<String> type;
//    List<String>
    Context context;
    private CheckboxCheckedListener checkedListener;


    public pendingAdapter(Context context, ArrayList<Integer> time, ArrayList<Integer> date, ArrayList<String> uid, ArrayList<String> type) {
        super(context, R.layout.retrieved_layout, R.id.uidComp);

        this.date = date;
        this.time = time;
        this.type = type;
        this.uid = uid;
        this.context = context;

    }

    class MyViewHolder
    {
        TextView Time ;
        TextView Date ;
        TextView Uid ;
        TextView Type ;
        CheckBox checkBox;

        MyViewHolder(View v)
        {
            Time = v.findViewById(R.id.timeComp);
            Date = v.findViewById(R.id.dateComp);
            Uid = v.findViewById(R.id.uidComp);
            Type = v.findViewById(R.id.typeComp);
            checkBox = v.findViewById(R.id.isComp);
        }

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        MyViewHolder holder = null;

        if (row == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.retrieved_layout, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder = (MyViewHolder) row.getTag();
        }

        holder.Time.setText(time.get(position).toString());
        holder.Date.setText(date.get(position).toString());
        holder.Type.setText(type.get(position));
        holder.Uid.setText(uid.get(position));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkedListener != null)
                {
                    checkedListener.getCheckBoxCheckedListener(position);
                }
            }
        });

        return super.getView(position, convertView, parent);
    }

    public interface CheckboxCheckedListener
    {

        void getCheckBoxCheckedListener(int position);
    }

    public void setCheckedListener(CheckboxCheckedListener checkedListener)
    {
        this.checkedListener = checkedListener;
    }


}
