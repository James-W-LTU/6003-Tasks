package com.example.hospimanagementapp.network;

import com.example.hospimanagementapp.data.entities.PatientEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

public interface ApiService {

    @GET("endpoint")
    Call<List<PatientEntity>> getData();

}
