package com.example.blooddonorv2;

import static android.view.View.*;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    ListView listView;
//    ListViewAdapter adapter;
//    String[] name;
//    String[] country;
//    String[] status;
//    String[] contact;
//    String[] blood;
//
//    ArrayList<Model> arrayList = new ArrayList<Model>();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        name= new String[]{"Anas","Muhammad","Sheikh","Ali","Maaz","Ammar","Adil","Rasheed"};
//        country = new String[]{"Pakistan","India","Nepal","Switerzland","Canada","Sri Lanka","Paris","France"};
//        status = new String[]{"Avaliable","Not Avaliable","On Demand", "On Prescribed","On Cash","Avaliable weekly","Monthly","Yearly"};
//        contact = new String[]{"0332","0445","0987","8723","2423","2341","2341","4135","5623"};
//
//        blood = new String[]{"O+","O-","A+","A-","AB+","AB-","O-","O+"};
//        listView = findViewById(R.id.listView);
//        for(int i = 0;i< name.length;i++)
//        {
//            Model model = new Model(blood[i],name[i],country[i],status[i],country[i]);
//            arrayList.add(model);
//        }
//        adapter = new ListViewAdapter(this,arrayList);
//        listView.setAdapter(adapter);
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//
//        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
//        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) MenuItemCompat.getActionView(myActionMenuItem);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                if(TextUtils.isEmpty(s))
//                {
//                    adapter.filter("");
//                    listView.clearTextFilter();
//                }
//                else
//                {
//                    adapter.bloodfilter(s);
//                }
//                return true;
//            }
//        });
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.action_settings)
//        {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}