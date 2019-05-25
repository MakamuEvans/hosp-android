package com.example.democollabmed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
