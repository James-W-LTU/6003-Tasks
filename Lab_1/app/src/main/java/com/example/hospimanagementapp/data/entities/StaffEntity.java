package com.example.hospimanagementapp.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "staff")

public class StaffEntity {

    public enum Role {ADMIN, CLINICIAN, RECEPTION }

    @PrimaryKey(autoGenerate = true) public long id;

    public String fullName;

    @NonNull public String email;

    @NonNull public Role role;

    public String adminPin;
}
