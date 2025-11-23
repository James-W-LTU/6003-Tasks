package com.example.hospimanagementapp.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.hospimanagementapp.data.entities.StaffEntity;

@Dao
public interface StaffDao {
    @Insert
    long insert(StaffEntity s);

    @Query("SELECT COUNT(*) FROM staff WHERE role = 'ADMIN'")
    int countAdmins();

    @Query("SELECT * FROM staff WHERE email = :email")
    StaffEntity getByEmail(String email);
}
