package com.example.democollabmed.api;

import com.example.democollabmed.models.AppointmentModel;
import com.example.democollabmed.models.Client;
import com.example.democollabmed.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("user")
    Call<User> logIn(@Header("Authorization") String authkey);

    @GET("appointments")
    Call<List<AppointmentModel>> getAllAppointments();

    @GET("clients")
    Call<List<Client>> getAllClients();

    @GET("doctors")
    Call<List<User>> getDoctors();

    @POST("check-in")
    Call<AppointmentModel> saveAppointment(@Body String data);
}
