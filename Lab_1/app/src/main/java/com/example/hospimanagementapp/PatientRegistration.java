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
    private EditText NHSNumber;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient_registration);

        FullName = findViewById(R.id.patientFullName);
        PhoneNumber = findViewById(R.id.patientPhoneNumber);
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
            String nhs = NHSNumber.getText().toString().trim();

            if (!validateInput(name, ageStr)) {
                return;
            }

            int age = Integer.parseInt(ageStr);

            PatientEntity newPatient = new PatientEntity(name, age, phone, nhs);

        }
}

