package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BloodBankListResponse extends GenericResponse {

    @SerializedName("data")
    private List<HospitalBloodBankData> bloodBankDataList;

    public List<HospitalBloodBankData> getBloodBankDataList() {
        return bloodBankDataList;
    }

    public void setBloodBankDataList(List<HospitalBloodBankData> bloodBankDataList) {
        this.bloodBankDataList = bloodBankDataList;
    }
}
