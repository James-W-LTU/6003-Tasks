package com.example.hospimanagementapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hospimanagementapp.data.entities.PatientEntity;

public class PatientRegistration extends AppCompatActivity {

    private EditText FullName;
    private EditText PhoneNumber;
    private EditText patientAge;
    private EditText NHSNumber;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient_registration);

        FullName = findViewById(R.id.patientFullName);
        PhoneNumber = findViewById(R.id.patientPhoneNumber);
        patientAge = findViewById(R.id.patientAge);
        NHSNumber = findViewById(R.id.patientNHSNumber);

        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePatient();
            }
        });
    }


    private void savePatient() {
            String name = FullName.getText().toString().trim();
            String phone = PhoneNumber.getText().toString().trim();
            String ageStr = patientAge.getText().toString().trim();
            String nhs = NHSNumber.getText().toString().trim();

            if (!validateInput(name, ageStr)) {
                return;
            }

            int ageInt = Integer.parseInt(ageStr);

            PatientEntity newPatient = new PatientEntity(name, phone, nhs, String.valueOf(ageInt));

        }

        private boolean validateInput(String name, String ageStr) {
            if (name.isEmpty()) {
                FullName.setError("Full name is required");
                return false;
            }

            if (ageStr.isEmpty()) {
                patientAge.setError("Age is required");
                return false;
            }

            return true;
        }
}

