package com.example.democollabmed;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.democollabmed.adapters.AppointmentsAdapter;
import com.example.democollabmed.api.ApiClient;
import com.example.democollabmed.api.ApiInterface;
import com.example.democollabmed.models.AppointmentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Appointments extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AppointmentsAdapter appointmentsAdapter;
    List<AppointmentModel> appointmentModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        appointmentModel = getAppointments();
//        Log.e("RESPONSE", String.valueOf(appointmentModel.size()));

    }

    private List<AppointmentModel> getAppointments(){
        Log.e("RESPONSE", "accessed");

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<AppointmentModel>> call = apiInterface.getAllAppointments();
        call.enqueue(new Callback<List<AppointmentModel>>() {
            @Override
            public void onResponse(Call<List<AppointmentModel>> call, Response<List<AppointmentModel>> response) {
                Log.e("RESPONSE", "success");
                //appointmentModel = response.body();
                recyclerView = findViewById(R.id.appointments_recycler);
                appointmentsAdapter = new AppointmentsAdapter(Appointments.this, response.body());
                recyclerView.setLayoutManager(new LinearLayoutManager(Appointments.this));
                recyclerView.setAdapter(appointmentsAdapter);
            }

            @Override
            public void onFailure(Call<List<AppointmentModel>> call, Throwable t) {

            }
        });
        return appointmentModel;
    }

}