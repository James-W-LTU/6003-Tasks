package com.example.hospimanagementapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.hospimanagementapp.AppDatabase;
import com.example.hospimanagementapp.data.dao.PatientDao;
import com.example.hospimanagementapp.data.dao.StaffDao;
import com.example.hospimanagementapp.data.entities.PatientEntity;
import com.example.hospimanagementapp.data.entities.StaffEntity;

@Database(entities = {StaffEntity.class, PatientEntity.class}, version = 1, exportSchema = false)

@TypeConverters({StaffEntity.class})
public abstract class HospiManagementDatabase extends RoomDatabase {

    private static volatile HospiManagementDatabase INSTANCE;
    public abstract StaffDao staffDao();
    public abstract PatientDao patientDao();

    public static AppDatabase getInstance(Context ctx) {
        if (INSTANCE == null) {
            synchronized (HospiManagementDatabase.class) {

                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(),
                            AppDatabase.class, "hms_secure.db").fallbackToDestructiveMigration().build();
                }
                }
            }
        return INSTANCE;
    }
}

