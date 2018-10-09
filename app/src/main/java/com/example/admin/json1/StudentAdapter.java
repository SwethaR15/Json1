package com.example.admin.json1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter  extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    Context context;
    List<GS> jobList =new ArrayList<>(  );
    public StudentAdapter(Context context, List<GS> jobList) {
        this.context = context;
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.StudentName.setText(jobList.get(i).getStudentName());
        myViewHolder.College.setText(jobList.get(i).getCollege());
        myViewHolder.Branch.setText(jobList.get(i).getBranch());
        myViewHolder.RollNo.setText(jobList.get(i).getRollno());
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView StudentName,College,Branch,RollNo;
        public MyViewHolder(@NonNull  final View itemView) {
            super( itemView );
            StudentName=itemView.findViewById( R.id.Name );
            Branch=itemView.findViewById( R.id.Branch );
            College=itemView.findViewById( R.id.college );
            RollNo=itemView.findViewById( R.id.Rollno );


        }
    }
}
