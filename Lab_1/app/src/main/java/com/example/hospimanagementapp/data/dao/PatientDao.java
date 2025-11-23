package com.example.hospimanagementapp.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hospimanagementapp.data.entities.PatientEntity;

import java.util.List;

@Dao
public interface PatientDao {
    @Insert
    void insert(PatientEntity p);

    @Query("SELECT * FROM patients")
    List<PatientEntity> getAll();
}



