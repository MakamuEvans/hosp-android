package com.example.democollabmed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.democollabmed.api.ApiClient;
import com.example.democollabmed.api.ApiInterface;
import com.example.democollabmed.models.Client;
import com.example.democollabmed.models.User;
import com.google.gson.Gson;

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
        init();
    }

    int doc_id;
    String weight;
    String temperature;
    private void init(){
        Gson gson = new Gson();
        client = gson.fromJson(getIntent().getStringExtra("data"), Client.class);
        setTitle("Client: "+client.getNames());
        doctors_spinner = findViewById(R.id.doc_spinner);
        getDoctors();

        doctors_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MakeAppointment2.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
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
