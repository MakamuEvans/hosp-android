package com.example.democollabmed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.democollabmed.adapters.LabTestAdapter;
import com.example.democollabmed.models.AppointmentModel;
import com.example.democollabmed.models.LabDiagnosis;
import com.google.gson.Gson;

import java.util.List;

public class LabTests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_tests);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Lab Tests");
        init();
    }

    private AppointmentModel appointmentModel;
    private List<LabDiagnosis> labDiagnoses;
    RecyclerView recyclerView;
    LabTestAdapter labTestAdapter;
    private void init(){
        Gson gson = new Gson();
        appointmentModel = gson.fromJson(getIntent().getStringExtra("data"), AppointmentModel.class);
        recyclerView = findViewById(R.id.lab_recycler);
        labTestAdapter = new LabTestAdapter(this, appointmentModel.getLab_diagnosis());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(labTestAdapter);
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
