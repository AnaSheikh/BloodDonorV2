package com.example.blooddonorv2;


import static androidx.recyclerview.widget.RecyclerView.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.ViewHolder> {

    ArrayList<Model> DonorArrayList;
    Context context;

    public DonorAdapter(ArrayList<Model> donorArrayList, Context context) {
        this.DonorArrayList = donorArrayList;
        this.context = context;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView mBlood,mName,mCountry,mStatus,mContact;

        public ViewHolder(@NonNull View itemView) {
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_donor,parent,false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Model modal = DonorArrayList.get(position);
            holder.mBlood.setText(modal.getBlood());
            holder.mContact.setText(modal.getContact());
            holder.mCountry.setText(modal.getCountry());
            holder.mName.setText(modal.getName());
            holder.mStatus.setText(modal.getStatus());

    }


    @Override
    public int getItemCount() {
        return DonorArrayList.size();
    }
}
