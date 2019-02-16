package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data;

import com.google.gson.annotations.SerializedName;

public class HospitalBloodBankData {
    @SerializedName("hospital_name")
    private String name;

    @SerializedName("blood_group")
    private String blood_grp;

    @SerializedName("units_of_blood")
    private int units_of_blood;

    @SerializedName("hospital_id")
    private int hospital_id;

    @SerializedName("hospital_state")
    private String state;

    @SerializedName("hospital_city")
    private String city;

    @SerializedName("hospital_address")
    private String address;

    @SerializedName("hospital_contact")
    private String hospital_contact;

    public void setName(String name) {
        this.name = name;
    }

    public void setBlood_grp(String blood_grp) {
        this.blood_grp = blood_grp;
    }

    public void setUnits_of_blood(int units_of_blood) {
        this.units_of_blood = units_of_blood;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHospital_contact(String hospital_contact) {
        this.hospital_contact = hospital_contact;
    }

    public String getName() {
        return name;
    }

    public String getBlood_grp() {
        return blood_grp;
    }

    public int getUnits_of_blood() {
        return units_of_blood;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getHospital_contact() {
        return hospital_contact;
    }
}
