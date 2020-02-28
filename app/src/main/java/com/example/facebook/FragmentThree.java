package com.example.facebook;


import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import static com.example.facebook.Database.Db_Name;

public class FragmentThree extends Fragment {

    Database db;
    ListView listView;

    public FragmentThree() {
    }


    public static FragmentThree newInstance() {
        FragmentThree fragmentThree = new FragmentThree();
        return fragmentThree;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void viewAllData(){

        Cursor resultSet = db.getAllRecords();

//        if((resultSet.getCount())==0){
//            Toast toast =Toast.makeText(FragmentThree.this,"no Data", Toast.LENGTH_SHORT);
//            toast.show();
//            return;
//        }

        StringBuffer buffer = new StringBuffer();

        ArrayList<String> list = new ArrayList<>();
        while (resultSet.moveToNext()){
            buffer.append(resultSet.getString(1)+"\n");
            buffer.append(resultSet.getString(2)+"\n");
            buffer.append(resultSet.getString(3)+"\n\n");
            list.add(buffer.toString());

        }
        ArrayAdapter adapter  = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


    }


}
