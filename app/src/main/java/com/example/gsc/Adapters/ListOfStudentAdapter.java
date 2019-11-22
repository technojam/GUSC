package com.example.gsc.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gsc.HelperClass.ListOfStudent;
import com.example.gsc.HelperClass.RegisterStudent;
import com.example.gsc.R;

import java.util.ArrayList;

public class ListOfStudentAdapter extends RecyclerView.Adapter<ListOfStudentAdapter.ListOfStudentHolder> {

    private ArrayList<RegisterStudent> mListOfStudent;
    Context context;

    public ListOfStudentAdapter(ArrayList<RegisterStudent> listOfStudents, Context context){
        mListOfStudent = listOfStudents;
        this.context = context;
    }

    @NonNull
    @Override
    public ListOfStudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_of_student_view, viewGroup,false);
        return new ListOfStudentHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListOfStudentHolder holder, int i) {

        RegisterStudent mStudentList = mListOfStudent.get(i);

        holder.mName_Of_Student.setText(mStudentList.getmName());
        holder.mAdmission_No.setText(mStudentList.getmAdmissionNo());
    }

    @Override
    public int getItemCount() {
        return mListOfStudent.size();
    }

    public class ListOfStudentHolder extends RecyclerView.ViewHolder{

        TextView mName_Of_Student, mAdmission_No;

        public ListOfStudentHolder(@NonNull View itemView) {
            super(itemView);

            mName_Of_Student = itemView.findViewById(R.id.Name_of_Student);
            mAdmission_No = itemView.findViewById(R.id.AdmissionNo_Of_Student);
        }
    }
}
