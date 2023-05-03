package com.example.project39.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project39.Domain.PopularDomain;
import com.example.project39.R;


import java.util.ArrayList;


public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<PopularDomain> popularDomains;

    public PopularAdapter(ArrayList<PopularDomain> popularDomains){
        this.popularDomains=popularDomains;
    }
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        holder.title.setText(popularDomains.get(position).getTitle());
        holder.fees.setText(String.valueOf(popularDomains.get(position).getFees()));
        String picurl="";

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(popularDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return popularDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,fees,addbtn;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fees=itemView.findViewById(R.id.fees);
            pic=itemView.findViewById(R.id.pic);
            addbtn=itemView.findViewById(R.id.addbtn);
        }
    }
}
