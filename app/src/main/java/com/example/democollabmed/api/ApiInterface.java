package com.example.democollabmed.api;

import com.example.democollabmed.models.AppointmentModel;
import com.example.democollabmed.models.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("appointments")
    Call<List<AppointmentModel>> getAllAppointments();

    @GET("clients")
    Call<List<Client>> getAllClients();
}