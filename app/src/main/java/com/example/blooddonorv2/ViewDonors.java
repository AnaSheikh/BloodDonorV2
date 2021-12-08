package com.example.blooddonorv2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewDonors extends AppCompatActivity {
    ArrayList<Model> DonorArrayList;
    ArrayList<Model> filtered;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) MenuItemCompat.getActionView(myActionMenuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s))
                {
                    adapter.filter("");

                }
                else
                {
                    adapter.bloodfilter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
