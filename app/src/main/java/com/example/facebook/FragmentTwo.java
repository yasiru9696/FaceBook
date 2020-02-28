package com.example.facebook;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FragmentTwo extends Fragment {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Database db;
    String[] getValue;
    Cursor cursor;
    StringBuffer buffer;
    public FragmentTwo() {

    }

    public static FragmentTwo newInstance() {
        FragmentTwo fragmentTwo = new FragmentTwo();
        return fragmentTwo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view , savedInstanceState);
         db = new Database(getContext(),Database.Db_Name,null,1);

       cursor = db.getAllRecords();
        searchView = view.findViewById(R.id.searchView);
        listView = view.findViewById(R.id.lv1);
        list = new ArrayList<>();
        adapter = new ArrayAdapter(getContext() , android.R.layout.simple_list_item_1 , list);
         buffer = new StringBuffer();

        while(cursor.moveToNext()){

            buffer.append(cursor.getString(1)+"\n");

        }
        getValue = buffer.toString().split("\n");


        for(int i=0;i<getValue.length;i++){
            list.add(getValue[i]);
        }

        listView.setAdapter(adapter);

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String s) {



               adapter.getFilter().filter(s);


               return false;



           }
       });



//                find_values(name_);


    }



//    private void find_values(String name_)
//    {
//       // MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
//        dataBaseManager = new MyDataBase(getContext(), DB_NAME, null,DB_VERSION);
//        StudentDetails student = dataBaseManager.findStudentDetails(.toString());
//        if (student != null) {
//            name_.setText.(String.valueOf(student.getAge()) + " " + student.getMarks + "" + student.getStudentName() + System.getProperty("line.separator"));
//             age.setText("");
//             marks.setText("");
//        } else {
//            System.out.println("not match");
//        }
//    }




}
