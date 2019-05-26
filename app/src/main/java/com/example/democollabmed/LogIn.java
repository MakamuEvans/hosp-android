package com.example.democollabmed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.democollabmed.api.ApiClient;
import com.example.democollabmed.api.ApiInterface;
import com.example.democollabmed.models.User;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        init();
    }

    private Button button;

    private void init() {
        button = findViewById(R.id.btn_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private EditText email, password;
    private ProgressDialog progressDialog;
    private void login() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast.makeText(LogIn.this, "All Fields required", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Authenticating...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        String credentials = Credentials.basic(email.getText().toString(), password.getText().toString());
        Log.e("RESPONSE", credentials);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<User> call = apiInterface.logIn(credentials);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    SharedPreferences.Editor editor = getSharedPreferences("collabmed", MODE_PRIVATE).edit();
                    editor.putString("user_name", response.body().getName());
                    editor.putInt("user_id", response.body().getId());
                    editor.putString("user_email", response.body().getEmail());
                    editor.apply();

                    Intent intent = new Intent(LogIn.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LogIn.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
