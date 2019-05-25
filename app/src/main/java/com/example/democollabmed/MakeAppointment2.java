package com.example.democollabmed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.democollabmed.models.Client;
import com.google.gson.Gson;

public class MakeAppointment2 extends AppCompatActivity {

    protected Client client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appointment2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init(){
        Gson gson = new Gson();
        client = gson.fromJson(getIntent().getStringExtra("data"), Client.class);
        setTitle("Client: "+client.getNames());
    }
}
