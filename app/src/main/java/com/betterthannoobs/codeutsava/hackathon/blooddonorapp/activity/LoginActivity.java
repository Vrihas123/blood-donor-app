package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.R;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.model.LoginData;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.model.LoginDataResponse;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.ApiServices;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.restapi.AppClient;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.PrefUtils;
import com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.ProgressDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText userName, password;
    private String donor_username, donor_password;
    private ProgressDialog progressDialog;
    private Button btLogin, btRegister;
    private PrefUtils prefUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefUtils = new PrefUtils(this);
        if (prefUtils.getIsLoggedIn()){
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
        progressDialog = new ProgressDialog();
        userName = findViewById(R.id.input_user_name_login);
        password = findViewById(R.id.input_password_login);
        btLogin = findViewById(R.id.bt_login);
        btRegister = findViewById(R.id.bt_register_back);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    public void sendData(){

        donor_username = userName.getText().toString().trim();
        donor_password = password.getText().toString().trim();
        if (donor_username == null || donor_password == null) {
            Toast.makeText(LoginActivity.this, "All fields are mandatory !", Toast.LENGTH_LONG).show();
        }else {
            LoginData data = new LoginData();

            data.setUsername(donor_username);
            data.setPassword(donor_password);
            progressDialog.showDialog("Logging, Please wait...", this);
            ApiServices apiServices = AppClient.getInstance().createService(ApiServices.class);
            Call<LoginDataResponse> call = apiServices.getLoginResult(data);
            call.enqueue(new Callback<LoginDataResponse>() {
                @Override
                public void onResponse(Call<LoginDataResponse> call, Response<LoginDataResponse> response) {
                    progressDialog.hideDialog();
                    if (response.isSuccessful()) {
                        LoginDataResponse loginDataResponse = response.body();
                        if (loginDataResponse != null){
                            if (loginDataResponse.isSuccess()){
                                prefUtils.saveAccessToken(loginDataResponse.getAccess_token());
                                prefUtils.setIsLoggedIn(true);
                                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginDataResponse> call, Throwable t) {
                    progressDialog.hideDialog();
                    Toast.makeText(LoginActivity.this, "Please try again", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
