package com.example.democollabmed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.democollabmed.api.ApiClient;
import com.example.democollabmed.api.ApiInterface;
import com.example.democollabmed.models.AppointmentModel;
import com.example.democollabmed.models.Client;
import com.example.democollabmed.models.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakeAppointment2 extends AppCompatActivity {

    protected Client client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appointment2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPreferences = getSharedPreferences("collabmed", MODE_PRIVATE);
        init();
    }

    SharedPreferences sharedPreferences;
    User doc;
    List<User> doctors;
    private EditText e_weight, e_temperature;
    private ProgressDialog progressDialog;
    private void save(){
        e_temperature = findViewById(R.id.temperature);
        e_weight = findViewById(R.id.weight);

        if (e_temperature.getText().toString().isEmpty() || e_weight.getText().toString().isEmpty()){
            Toast.makeText(MakeAppointment2.this, "Fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        JsonArray datas = new JsonArray();

        JsonObject object = new JsonObject();
        object.addProperty("weight",e_weight.getText().toString());
        object.addProperty("temperature", e_temperature.getText().toString());
        object.addProperty("client", client.getId());
        object.addProperty("doctor", doc.getId());
        object.addProperty("receptionist_id", sharedPreferences.getInt("user_id", 0));

        datas.add(object);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<AppointmentModel> call = apiInterface.saveAppointment(new Gson().toJson(object));
        call.enqueue(new Callback<AppointmentModel>() {
            @Override
            public void onResponse(Call<AppointmentModel> call, Response<AppointmentModel> response) {
                progressDialog.dismiss();
                Toast.makeText(MakeAppointment2.this, "Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MakeAppointment2.this, MainActivity.class));
            }

            @Override
            public void onFailure(Call<AppointmentModel> call, Throwable t) {

            }
        });
    }

    private Button button;
    private void init(){
        Gson gson = new Gson();
        client = gson.fromJson(getIntent().getStringExtra("data"), Client.class);
        setTitle("Client: "+client.getNames());
        doctors_spinner = findViewById(R.id.doc_spinner);
        getDoctors();


        button = findViewById(R.id.create_appointment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        doctors_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MakeAppointment2.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                doc = doctors.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private Spinner doctors_spinner;
    private void getDoctors(){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<User>> call = apiInterface.getDoctors();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                String[] doctor_names = new String[response.body().size()];
                doctors = response.body();
                for(int i=0; i<response.body().size(); i++){
                    //Storing names to string array
                    doctor_names[i] = response.body().get(i).getName();
                    Log.e("RESPONSE", response.body().get(i).toString());
                }
                ArrayAdapter<String> adapter;
                adapter = new ArrayAdapter<String>(MakeAppointment2.this, android.R.layout.simple_list_item_1, doctor_names);
                doctors_spinner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}
