package com.example.democollabmed.models;

public class AppointmentModel {
    private int id;
    private int client_id;
    private int reception_id;
    private String weight;
    private String temperature;
    private String remarks;
    private Client client;

    public AppointmentModel(int id, int client_id, int reception_id, String weight, String temperature, String remarks, Client client) {
        this.id = id;
        this.client_id = client_id;
        this.reception_id = reception_id;
        this.weight = weight;
        this.temperature = temperature;
        this.remarks = remarks;
        this.client = client;
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
                '}';
    }
}
