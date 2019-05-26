package com.example.democollabmed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.democollabmed.adapters.LabTestAdapter;
import com.example.democollabmed.adapters.RadiologyTestAdapter;
import com.example.democollabmed.models.AppointmentModel;
import com.example.democollabmed.models.RadiologyDiagnosis;
import com.google.gson.Gson;

import java.util.List;

public class RadiologyTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiology_test);
        setTitle("Radiology Test");
        init();
    }

    private AppointmentModel appointmentModel;
    private List<RadiologyDiagnosis> radiologyDiagnoses;
    RecyclerView recyclerView;
    RadiologyTestAdapter radiologyTestAdapter;
    private void init(){
        Gson gson = new Gson();
        appointmentModel = gson.fromJson(getIntent().getStringExtra("data"), AppointmentModel.class);
        recyclerView = findViewById(R.id.radiology_recycler);
        radiologyTestAdapter = new RadiologyTestAdapter(this, appointmentModel.getRadiology_diagnosis());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(radiologyTestAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lab_tests, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_new){
            Toast.makeText(this, "Create Action", Toast.LENGTH_SHORT).show();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
