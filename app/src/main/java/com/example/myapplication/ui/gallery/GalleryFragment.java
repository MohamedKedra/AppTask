package com.example.myapplication.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.UserPreferences;

public class GalleryFragment extends Fragment {

    private AppCompatEditText usernameEt,currentEt,maxEt;
    private Button save;
    private UserPreferences userPreferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        usernameEt = root.findViewById(R.id.et_username);
        currentEt = root.findViewById(R.id.et_current);
        maxEt = root.findViewById(R.id.et_max);
        save = root.findViewById(R.id.btn_save);

        userPreferences = new UserPreferences(getActivity());

        usernameEt.setText(userPreferences.getUserName());
        currentEt.setText(userPreferences.getCurrentNum());
        maxEt.setText(userPreferences.getMaxNum());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        return root;
    }

    public void saveData(){

        String username = usernameEt.getText().toString();
        String max = maxEt.getText().toString();

        if(!username.isEmpty() && !max.isEmpty()){
            userPreferences.setUserName(username);
            userPreferences.setMaxNum(max);
        }else {
            Toast.makeText(getActivity(), "Enter all data", Toast.LENGTH_SHORT).show();
        }
    }
}