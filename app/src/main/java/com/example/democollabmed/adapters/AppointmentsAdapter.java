package com.example.democollabmed.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.democollabmed.Appointments;
import com.example.democollabmed.R;
import com.example.democollabmed.ViewAppointment;
import com.example.democollabmed.models.AppointmentModel;
import com.google.gson.Gson;

import java.util.List;

public class AppointmentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<AppointmentModel> appointments;

    public AppointmentsAdapter(Context context, List<AppointmentModel> appointments) {
        this.context = context;
        this.appointments = appointments;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.appointment_card, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        AppointmentModel appointmentModel = appointments.get(i);
        myViewHolder holder = (myViewHolder) viewHolder;
        holder.names.setText(appointmentModel.getClient().getNames());
        holder.dob.setText(appointmentModel.getClient().getDob());
        holder.gender.setText(appointmentModel.getClient().getFormatted_gender());
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public TextView names, dob, gender;
        public Button view;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            names = itemView.findViewById(R.id.client_name);
            dob = itemView.findViewById(R.id.dob);
            gender = itemView.findViewById(R.id.gender);
            view = itemView.findViewById(R.id.view);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = getLayoutPosition();
                    AppointmentModel appointment = appointments.get(i);
                    Gson gson = new Gson();
                    String data = gson.toJson(appointment);
                    Intent intent = new Intent(v.getContext(), ViewAppointment.class);
                    intent.putExtra("data", data);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
