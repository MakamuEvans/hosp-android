package com.example.democollabmed.api;

import com.example.democollabmed.models.AppointmentModel;
import com.example.democollabmed.models.Client;
import com.example.democollabmed.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("appointments")
    Call<List<AppointmentModel>> getAllAppointments();

    @GET("clients")
    Call<List<Client>> getAllClients();

    @GET("doctors")
    Call<List<User>> getDoctors();
}
