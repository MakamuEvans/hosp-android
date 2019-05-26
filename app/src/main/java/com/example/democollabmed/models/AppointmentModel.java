package com.example.democollabmed.models;

import java.util.List;

public class AppointmentModel {
    private int id;
    private int client_id;
    private int reception_id;
    private String weight;
    private String temperature;
    private String remarks;
    private Client client;
    private DoctorDiagnosis doctor_diagnosis;
    private List<LabDiagnosis> lab_diagnosis;
    private List<RadiologyDiagnosis> radiology_diagnosis;
    private List<Medication> medication;

    public AppointmentModel(int id, int client_id, int reception_id, String weight, String temperature, String remarks, Client client, DoctorDiagnosis doctor_diagnosis, List<LabDiagnosis> lab_diagnosis, List<RadiologyDiagnosis> radiology_diagnosis, List<Medication> medication) {
        this.id = id;
        this.client_id = client_id;
        this.reception_id = reception_id;
        this.weight = weight;
        this.temperature = temperature;
        this.remarks = remarks;
        this.client = client;
        this.doctor_diagnosis = doctor_diagnosis;
        this.lab_diagnosis = lab_diagnosis;
        this.radiology_diagnosis = radiology_diagnosis;
        this.medication = medication;
    }

    public List<Medication> getMedication() {
        return medication;
    }

    public void setMedication(List<Medication> medication) {
        this.medication = medication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getReception_id() {
        return reception_id;
    }

    public void setReception_id(int reception_id) {
        this.reception_id = reception_id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DoctorDiagnosis getDoctor_diagnosis() {
        return doctor_diagnosis;
    }

    public void setDoctor_diagnosis(DoctorDiagnosis doctor_diagnosis) {
        this.doctor_diagnosis = doctor_diagnosis;
    }

    public List<LabDiagnosis> getLab_diagnosis() {
        return lab_diagnosis;
    }

    public void setLab_diagnosis(List<LabDiagnosis> lab_diagnosis) {
        this.lab_diagnosis = lab_diagnosis;
    }

    public List<RadiologyDiagnosis> getRadiology_diagnosis() {
        return radiology_diagnosis;
    }

    public void setRadiology_diagnosis(List<RadiologyDiagnosis> radiology_diagnosis) {
        this.radiology_diagnosis = radiology_diagnosis;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", reception_id=" + reception_id +
                ", weight='" + weight + '\'' +
                ", temperature='" + temperature + '\'' +
                ", remarks='" + remarks + '\'' +
                ", client=" + client +
                ", doctor_diagnosis=" + doctor_diagnosis +
                ", lab_diagnosis=" + lab_diagnosis +
                ", radiology_diagnosis=" + radiology_diagnosis +
                '}';
    }
}
