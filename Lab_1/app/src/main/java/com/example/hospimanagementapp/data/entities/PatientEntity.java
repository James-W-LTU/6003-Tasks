package com.example.hospimanagementapp.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients")

public class PatientEntity {

    @PrimaryKey(autoGenerate = true) public int id;

    @NonNull
    public String nhs;
    public String name;
    public String age;
    public String phone;

    public PatientEntity(@NonNull String name, String age, String phone, String nhs) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.nhs = nhs;
    }
}
