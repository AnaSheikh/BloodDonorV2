package com.example.blooddonorv2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewDonors extends AppCompatActivity {
    ArrayList<Model> DonorArrayList;
    DBHelper DB ;
    DonorAdapter adapter;
    RecyclerView donorRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        donorRV = (RecyclerView) findViewById(R.id.viewdonors);
        DB = new DBHelper(this);
        DisplayDonors();
    }
    public void DisplayDonors()
    {
        DonorArrayList = new ArrayList<>(DB.readDonors());
        donorRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        donorRV.setItemAnimator(new DefaultItemAnimator());
        adapter = new DonorAdapter(DonorArrayList,getApplicationContext());
        donorRV.setAdapter(adapter);
    }
}
