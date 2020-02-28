package com.example.facebook;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import static com.example.facebook.Database.Db_Name;


public class FragmentOne extends Fragment {

    EditText name,age,mark;
    Button add;
    Database db;

    String Name,Age,Marks;


    public static FragmentOne newInstance(){
        FragmentOne fragmentOne=new FragmentOne();
        return fragmentOne;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new Database(getContext(),Db_Name,null,1);

        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        mark = view.findViewById(R.id.marks);

        add = view.findViewById(R.id.btn);

        add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Name = name.getText().toString();
                Age = age.getText().toString();
                Marks = mark.getText().toString();

                db.addRecords("Name:"+ Name,"Age:"+age,"Marks:"+mark);

            }
        });

    }

   }
