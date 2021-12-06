package com.example.blooddonorv2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
   Context mContext;
   LayoutInflater inflater;
   List<Model> modelList;
   ArrayList<Model> arrayList;

    public ListViewAdapter(Context context, List<Model> modelList) {
        this.mContext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }
    public static class ViewHolder{
        TextView mBlood,mName,mCountry,mStatus,mContact;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
    ViewHolder holder;
    if(view == null)
    {
        holder= new ViewHolder();
        view = inflater.inflate(R.layout.row,null);
        holder.mBlood = view.findViewById(R.id.textView1);
        holder.mName = view.findViewById(R.id.textView2);
        holder.mCountry = view.findViewById(R.id.textView3);
        holder.mStatus = view.findViewById(R.id.textView4);
        holder.mContact= view.findViewById(R.id.textView5);

        view.setTag(holder);
    }
    else
    {
        holder = (ViewHolder) view.getTag();
    }
    holder.mBlood.setText(modelList.get(position).getBlood());
    holder.mName.setText(modelList.get(position).getName());
    holder.mCountry.setText(modelList.get(position).getCountry());
    holder.mStatus.setText(modelList.get(position).getStatus());
    holder.mContact.setText(modelList.get(position).getContact());

    return view;
    }
    public void filter(String charText)
    {
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if(charText.length()==0)
        {
            modelList.addAll(arrayList);
        }
        else {
            for(Model model : arrayList)
            {
                if(model.getName().toLowerCase(Locale.getDefault())
                    .contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
    public void bloodfilter(String charText)
    {
        charText=  charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if(charText.length()==0)
        {
            modelList.addAll(arrayList);
        }
        else {
            for (Model model : arrayList)
            {
                if(model.getBlood().toLowerCase(Locale.getDefault())
                .contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();


    }
    public void countryfilter(String charText)
    {
        charText=  charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if(charText.length()==0)
        {
            modelList.addAll(arrayList);
        }
        else {
            for (Model model : arrayList)
            {
                if(model.getCountry().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();


    }
}
