package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import static com.example.facebook.Database.Db_Name;

public class MainActivity extends AppCompatActivity {

    Database db;
    ViewPager viewPager;
    FragmentAdepter adapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
      }

    public void initviews(){

        db = new Database(this,Db_Name,null,1);
        viewPager = findViewById(R.id.fragment_pager);
        adapter = new FragmentAdepter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.search);
        tabLayout.getTabAt(2).setIcon(R.drawable.list);


    }




}