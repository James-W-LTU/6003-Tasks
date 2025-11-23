package com.example.hospimanagementapp.data.converters;

import androidx.room.TypeConverter;

import com.example.hospimanagementapp.data.entities.StaffEntity;

public class Converters {

    @TypeConverter
    public static String fromRole(StaffEntity.Role role) {
        return role == null ? null : role.name();
    }

    @TypeConverter
    public static StaffEntity.Role toRole(String roleName) {
        return roleName == null ? null : StaffEntity.Role.valueOf(roleName);
    }
}
