package com.example.myapplication.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientHolder> {
    ArrayList<Patient> patients;
    public PatientAdapter(ArrayList<Patient> patients){
        this.patients = patients;
    }

    @NonNull
    @Override
    public PatientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PatientHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_patient,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PatientHolder holder, int position) {
        Patient patient = patients.get(position);
        holder.textView.setText((position+1)+" "+patient.getName()+"/"+patient.getAge()+"/"+patient.getEmail());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    static class PatientHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public PatientHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_patient);
        }
    }
}
