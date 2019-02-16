package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data;

import com.google.gson.annotations.SerializedName;

public class DonorData {
    @SerializedName("full_name")
    private String full_name;

    @SerializedName("blood_group")
    private String blood_group;

    @SerializedName("gender")
    private String gender;

    @SerializedName("city")
    private String city;

    @SerializedName("state")
    private String state;

    @SerializedName("address")
    private String address;

    @SerializedName("contact")
    private String contact;

    @SerializedName("weight")
    private int weight;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
