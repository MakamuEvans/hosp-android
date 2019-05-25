package com.example.democollabmed.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.democollabmed.R;
import com.example.democollabmed.models.AppointmentModel;
import com.example.democollabmed.models.Client;

import java.util.List;

public class ClientsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Client> clients;

    public ClientsAdapter(Context context, List<Client> clients) {
        this.context = context;
        this.clients = clients;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.client_card, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Client client = clients.get(i);
        myViewHolder holder = (myViewHolder) viewHolder;
        holder.names.setText(client.getNames());
        holder.dob.setText(client.getDob());
        holder.gender.setText(client.getFormatted_gender());
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public TextView names, dob, gender;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            names = itemView.findViewById(R.id.client_name);
            dob = itemView.findViewById(R.id.dob);
            gender = itemView.findViewById(R.id.gender);
        }
    }
}
