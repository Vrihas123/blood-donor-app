package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DonorListResponse extends GenericResponse{

    @SerializedName("donor_list")
    private List<DonorData> donorDataList;

    public List<DonorData> getDonorDataList() {
        return donorDataList;
    }

    public void setDonorDataList(List<DonorData> donorDataList) {
        this.donorDataList = donorDataList;
    }
}
