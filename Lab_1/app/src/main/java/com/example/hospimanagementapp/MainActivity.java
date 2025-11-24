package com.example.hospimanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonPatientReg;
    private Button buttonAdminPortal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        buttonPatientReg = findViewById(R.id.buttonPatientReg);
        buttonPatientReg.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PatientRegistrationActivity.class);
            startActivity(intent);
        });

        buttonAdminPortal = findViewById(R.id.buttonAdminPortal);
        buttonAdminPortal.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdminPortalActivity.class);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
