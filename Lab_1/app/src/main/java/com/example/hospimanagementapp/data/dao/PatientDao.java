package com.example.hospimanagementapp.data.dao;

public interface PatientDao {
    @Insert
    void insert(Patient p);

    @Query("SELECT * FROM patients")
    List<Patient> getAll();
}



