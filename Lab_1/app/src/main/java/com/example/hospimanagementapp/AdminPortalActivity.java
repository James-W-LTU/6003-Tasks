package com.example.hospimanagementapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hospimanagementapp.data.entities.PatientEntity;
import com.example.hospimanagementapp.network.ApiService;
import com.example.hospimanagementapp.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminPortalActivity extends AppCompatActivity {

    private static final String TAG = "AdminPortalActivity";
    private Button buttonFetchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_portal);

        buttonFetchData = findViewById(R.id.buttonFetchPatients);
        buttonFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchPatientsData();
            }
        });
    }

    private void fetchPatientsData() {
        ApiService apiService = RetrofitClient.getApiService();
        Call<List<PatientEntity>> call = apiService.getData();

        Toast.makeText(this, "Fetching data...", Toast.LENGTH_SHORT).show();

        call.enqueue(new Callback<List<PatientEntity>>() {
            @Override
            public void onResponse(Call<List<PatientEntity>> call, Response<List<PatientEntity>> response) {
                if (response.isSuccessful()) {
                    List<PatientEntity> patients = response.body();
                    String successMessage = "Data fetched successfully. Patients count: " + patients.size();
                    Log.d(TAG, successMessage);
                    Toast.makeText(AdminPortalActivity.this, successMessage, Toast.LENGTH_SHORT).show();
                }
                else {
                    String errorMessage = "API Error: " + response.code();
                    Log.e(TAG, errorMessage);
                    Toast.makeText(AdminPortalActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PatientEntity>> call, Throwable t) {
                String errorMessage = "Network Error: " + t.getMessage();
                Log.e(TAG, errorMessage);
                Toast.makeText(AdminPortalActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
