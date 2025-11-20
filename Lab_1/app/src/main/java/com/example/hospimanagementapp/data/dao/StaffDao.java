package com.example.hospimanagementapp.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface StaffDao {
    @Insert
    long insert(Staff s);

    @Query("SELECT COUNT(*) FROM staff WHERE role = 'ADMIN'")
    int countAdmins();

    @Query("SELECT * FROM staff WHERE email = :email")
    Staff getByEmail(String email);
}
