package com.example.democollabmed;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.democollabmed.adapters.ClientsAdapter;
import com.example.democollabmed.api.ApiClient;
import com.example.democollabmed.api.ApiInterface;
import com.example.democollabmed.models.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakeAppointment1 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ClientsAdapter clientsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appointment1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Select Client");
        init();
    }

    private void init(){
        getClients();
    }

    private ProgressDialog progressDialog;
    private void getClients(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Clients...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Client>> call = apiInterface.getAllClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                progressDialog.dismiss();
                recyclerView = findViewById(R.id.client_recycler);
                clientsAdapter = new ClientsAdapter(MakeAppointment1.this, response.body());
                recyclerView.setLayoutManager(new LinearLayoutManager(MakeAppointment1.this));
                recyclerView.setAdapter(clientsAdapter);
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {

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
