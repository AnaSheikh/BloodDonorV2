package com.example.blooddonorv2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.ViewHolder> {

    ArrayList<Model> DonorArrayList;
    Context context;
    List<Model> modelList;


    public DonorAdapter(ArrayList<Model> donorArrayList, Context context) {
        this.DonorArrayList = donorArrayList;
        this.context = context;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView mBlood,mName,mCountry,mStatus,mContact;

        public ViewHolder(View itemView) {
            super(itemView);

            mBlood = itemView.findViewById(R.id.textView1);
            mName = itemView.findViewById(R.id.textView2);
            mCountry = itemView.findViewById(R.id.textView3);
            mStatus = itemView.findViewById(R.id.textView4);
            mContact= itemView.findViewById(R.id.textView5);
        }
    }

    @NonNull
    @Override
    public DonorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donor,parent,false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(final DonorAdapter.ViewHolder holder, int position) {
            holder.mBlood.setText(DonorArrayList.get(position).getBlood());
            holder.mContact.setText(DonorArrayList.get(position).getContact());
            holder.mCountry.setText(DonorArrayList.get(position).getCountry());
            holder.mName.setText(DonorArrayList.get(position).getName());
            holder.mStatus.setText(DonorArrayList.get(position).getStatus());

    }


    @Override
    public int getItemCount() {
        return DonorArrayList.size();
    }
    public void filter(String charText)
    {
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if(charText.length()==0)
        {
            modelList.addAll(DonorArrayList);
        }
        else {
            for(Model model : DonorArrayList)
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
            modelList.addAll(DonorArrayList);
        }
        else {
            for (Model model : DonorArrayList)
            {
                if(model.getBlood().toLowerCase(Locale.getDefault())
                .contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();


    }
}
