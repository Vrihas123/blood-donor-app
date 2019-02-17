package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.DonorData;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.data.GenericResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.ApiServices;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.AppClient;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.ProgressDialog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText firstName, lastname, userName, password, contact, weight, blood_group, gender, age, city, state, address;
    private String donor_first_name, donor_lastname, donor_username, donor_password, donor_contact, donor_weight, donor_blood_group, donor_gender, donor_age, donor_city, donor_state, donor_address;
    private Button register;
    private String fcm_token = "";
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseApp.initializeApp(this);
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
//To do//
                            return;
                        }
                        fcm_token = task.getResult().getToken();
                        Log.d("FCM", fcm_token);
                    }
                });
        progressDialog = new ProgressDialog();
        firstName = findViewById(R.id.input_first_name);
        lastname = findViewById(R.id.input_last_name);
        userName = findViewById(R.id.input_user_name);
        password = findViewById(R.id.input_password);
        contact = findViewById(R.id.input_contact);
        weight = findViewById(R.id.input_weight);
        blood_group = findViewById(R.id.input_blood_group);
        gender = findViewById(R.id.input_gender);
        age = findViewById(R.id.input_age);
        city = findViewById(R.id.input_city);
        state = findViewById(R.id.input_state);
        address = findViewById(R.id.input_address);
        register = findViewById(R.id.bt_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });


    }

    public void sendData() {
        donor_first_name = firstName.getText().toString().trim();
        donor_lastname = lastname.getText().toString().trim();
        donor_username = userName.getText().toString().trim();
        donor_password = password.getText().toString().trim();
        donor_contact = contact.getText().toString().trim();
        donor_weight = weight.getText().toString().trim();
        donor_blood_group = blood_group.getText().toString().trim();
        donor_gender = gender.getText().toString().trim();
        donor_age = age.getText().toString().trim();
        donor_city = city.getText().toString().trim();
        donor_state = state.getText().toString().trim();
        donor_address = address.getText().toString().trim();
        if (donor_first_name == null || donor_lastname == null || donor_username == null || donor_password == null || donor_contact == null || donor_weight == null || donor_blood_group == null || donor_gender == null || donor_age == null || donor_city == null || donor_city == null || donor_state == null) {
            Toast.makeText(RegisterActivity.this, "All fields are mandatory !", Toast.LENGTH_LONG).show();
        }else {
            DonorData data = new DonorData();


            data.setFirst_name(donor_first_name);
            data.setLast_name(donor_lastname);
            data.setUsername(donor_username);
            data.setPassword(donor_password);
            data.setAddress(donor_address);
            data.setAge(Integer.parseInt(donor_age));
            data.setContact(donor_contact);
            data.setBlood_group(donor_blood_group);
            data.setCity(donor_city);
            data.setState(donor_state);
            data.setGender(donor_gender);
            data.setFcm_token(fcm_token);
            progressDialog.showDialog("Registering, Please wait...", this);
            ApiServices apiServices = AppClient.getInstance().createService(ApiServices.class);
            Call<GenericResponse> call = apiServices.getRegisterResult(data);

            call.enqueue(new Callback<GenericResponse>() {
                @Override
                public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
                    progressDialog.hideDialog();
                    if (response.isSuccessful()) {
                        GenericResponse genericResponse = response.body();
                        if (genericResponse != null) {
                            if (genericResponse.isSuccess()) {
                                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<GenericResponse> call, Throwable t) {
                    progressDialog.hideDialog();
                    Toast.makeText(RegisterActivity.this, "Please try again", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
