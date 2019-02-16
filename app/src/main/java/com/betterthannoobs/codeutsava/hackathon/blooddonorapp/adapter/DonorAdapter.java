package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.DonorData;

import java.util.ArrayList;
import java.util.List;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<DonorData> donorDataList = new ArrayList<>();

    public DonorAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setDonorDataList(List<DonorData> donorDataList) {
        this.donorDataList = donorDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.donor_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        final DonorData data = donorDataList.get(i);
        holder.name.setText(data.getFull_name());
        holder.grp.setText(data.getBlood_group());
        holder.address.setText(data.getAddress());
        holder.gender.setText(data.getGender());
        holder.contact.setText(data.getContact());
    }

    @Override
    public int getItemCount() {
        return donorDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, grp, gender, address, contact;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_donor_name);
            grp = itemView.findViewById(R.id.txt_donor_blood_grp);
            gender = itemView.findViewById(R.id.txt_donor_gender);
            address = itemView.findViewById(R.id.txt_donor_address);
            contact = itemView.findViewById(R.id.txt_donor_contact);
        }
    }
}
