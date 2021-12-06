package com.example.blooddonorv2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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
        setContentView(R.layout.activity_donor);

        DonorArrayList = new ArrayList<>();

        DonorArrayList = DB.readDonors();

        adapter = new DonorAdapter(DonorArrayList,ViewDonors.this);
        donorRV = findViewById(R.id.viewdonors);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewDonors.this,RecyclerView.VERTICAL,false);
        donorRV.setLayoutManager(linearLayoutManager);

        donorRV.setAdapter(adapter);
    }
}
