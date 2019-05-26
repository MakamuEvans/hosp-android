package com.example.democollabmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.democollabmed.models.AppointmentModel;
import com.google.gson.Gson;

public class ViewAppointment extends AppCompatActivity {

    protected AppointmentModel appointmentModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private TextView names,dob,gender,blood, docNotes;
    private Button lab,radiology,medication;
    private void init(){
        names = findViewById(R.id.client_names);
        dob = findViewById(R.id.client_dob);
        gender = findViewById(R.id.client_gender);
        blood = findViewById(R.id.client_blood);
        docNotes = findViewById(R.id.doc_notes);
        Gson gson = new Gson();
        appointmentModel = gson.fromJson(getIntent().getStringExtra("data"), AppointmentModel.class);
        setTitle("View Appointment");
        names.setText(appointmentModel.getClient().getNames());
        dob.setText(appointmentModel.getClient().getDob());
        gender.setText(appointmentModel.getClient().getFormatted_gender());
        blood.setText(appointmentModel.getClient().getBlood_type());
        docNotes.setText(appointmentModel.getDoctor_diagnosis().getRemarks());

        lab = findViewById(R.id.btn_lab);
        radiology = findViewById(R.id.btn_radiology);
        medication = findViewById(R.id.btn_medication);

        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String data = gson.toJson(appointmentModel);
                Intent intent = new Intent(v.getContext(), LabTests.class);
                intent.putExtra("data", data);
                v.getContext().startActivity(intent);
            }
        });

        radiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String data = gson.toJson(appointmentModel);
                Intent intent = new Intent(v.getContext(), RadiologyTest.class);
                intent.putExtra("data", data);
                v.getContext().startActivity(intent);
            }
        });

        medication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String data = gson.toJson(appointmentModel);
                Intent intent = new Intent(v.getContext(), Medication.class);
                intent.putExtra("data", data);
                v.getContext().startActivity(intent);
            }
        });
    }
}
