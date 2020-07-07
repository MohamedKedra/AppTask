package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.UserPreferences;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private AppCompatEditText nameEt, emailEt, ageEt;
    private RadioGroup radioGroup;
    private MaterialRadioButton genderRadioButton;
    private View root;
    private RecyclerView patients;
    private FloatingActionButton fab;
    private PatientAdapter adapter;
    private ArrayList<Patient> patientsList;
    private UserPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        this.root = root;
        nameEt = root.findViewById(R.id.et_name);
        emailEt = root.findViewById(R.id.et_email);
        ageEt = root.findViewById(R.id.et_age);
        radioGroup = root.findViewById(R.id.rg_group);
        patients = root.findViewById(R.id.rv_patients);
        fab = root.findViewById(R.id.fab);
        if (patientsList == null){
            patientsList = new ArrayList();
        }
        preferences = new UserPreferences(getActivity());
        preferences.setCurrentNum(String.valueOf(patientsList.size()));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderRadioButton = root.findViewById(selectedId);
                if (selectedId == -1) {
                    Toast.makeText(getActivity(), "Nothing selected", Toast.LENGTH_SHORT).show();
                } else {

                    addNewPatient();
                }
            }
        });
        return root;
    }

    private void addNewPatient(){

        String name = nameEt.getText().toString();
        String email = emailEt.getText().toString();
        String age = ageEt.getText().toString();
        if(!name.isEmpty() && !email.isEmpty() && !age.isEmpty()){
            Patient patient = new Patient();
            patient.setName(name);
            patient.setEmail(email);
            patient.setAge(age);
            patient.setGender(genderRadioButton.getText().toString());
            patientsList.add(patient);
            preferences.setCurrentNum(String.valueOf(patientsList.size()));
            adapter = new PatientAdapter(patientsList);
            patients.setLayoutManager(new LinearLayoutManager(getActivity()));
            patients.setAdapter(adapter);
        }else {
            Toast.makeText(getActivity(), "Enter all data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        patientsList.clear();
        adapter.notifyDataSetChanged();

        Toast.makeText(getActivity(), "Data cleared", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}