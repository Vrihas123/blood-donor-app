package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.HospitalBloodBankData;

import java.util.ArrayList;
import java.util.List;

public class HospitalBloodBankAdapter extends RecyclerView.Adapter<HospitalBloodBankAdapter.MyViewHolder> {


    private Context context;
    private LayoutInflater layoutInflater;
    private List<HospitalBloodBankData> hospitalBloodBankDataList = new ArrayList<>();

    public HospitalBloodBankAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setHospitalBloodBankDataList(List<HospitalBloodBankData> hospitalBloodBankDataList) {
        this.hospitalBloodBankDataList = hospitalBloodBankDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.blood_bank_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        final HospitalBloodBankData data = hospitalBloodBankDataList.get(i);
        holder.name.setText(data.getName());
        holder.grp.setText(data.getBlood_grp());
        holder.units.setText(String.valueOf(data.getUnits_of_blood()));
        holder.city.setText(data.getCity());
        holder.state.setText(data.getState());
        holder.address.setText(data.getAddress());
        holder.contact.setText(data.getHospital_contact());
    }

    @Override
    public int getItemCount() {
        return hospitalBloodBankDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, grp, units, city, state, address, contact;
       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           name = itemView.findViewById(R.id.txt_blood_bank_name);
           grp = itemView.findViewById(R.id.txt_blood_bank_grp);
           units = itemView.findViewById(R.id.txt_blood_bank_units);
           city = itemView.findViewById(R.id.txt_blood_bank_city);
           state = itemView.findViewById(R.id.txt_blood_bank_state);
           address = itemView.findViewById(R.id.txt_blood_bank_address);
           contact = itemView.findViewById(R.id.txt_blood_bank_contact);
       }
   }
}
