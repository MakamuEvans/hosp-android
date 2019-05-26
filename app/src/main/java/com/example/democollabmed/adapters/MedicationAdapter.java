package com.example.democollabmed.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.democollabmed.R;
import com.example.democollabmed.models.Medication;
import com.example.democollabmed.models.RadiologyDiagnosis;
import com.google.gson.Gson;

import java.util.List;

public class MedicationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Medication> medications;

    public MedicationAdapter(Context context, List<Medication> medications) {
        this.context = context;
        this.medications = medications;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lab_test_card, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Medication medication = medications.get(i);
        myViewHolder holder = (myViewHolder) viewHolder;
        holder.names.setText(medication.getDrug().getName());
        holder.remarks.setText(medication.getRemarks());
    }

    @Override
    public int getItemCount() {
        return medications.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public TextView names, dated, remarks;
        public Button make_remarks;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            names = itemView.findViewById(R.id.test_name);
            dated = itemView.findViewById(R.id.test_dated);
            remarks = itemView.findViewById(R.id.test_remarks);
            make_remarks = itemView.findViewById(R.id.make_remark);

            make_remarks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i = getLayoutPosition();
                    Medication medication = medications.get(i);
                    Gson gson = new Gson();
                    String data = gson.toJson(medication);
                   // Intent intent = new Intent(v.getContext(), MakeAppointment2.class);
                    //intent.putExtra("data", data);
                    //v.getContext().startActivity(intent);
                }
            });
        }
    }
}
