package com.example.hospimanagementapp.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients")

public class PatientEntity {

    @PrimaryKey(autoGenerate = true) public int id;

    @NonNull
    String nhsNumber;

    public String name;

    public String dob;

    public String phone;

    public String email;
}
