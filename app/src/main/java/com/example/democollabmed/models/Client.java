package com.example.democollabmed.models;

public class Client {
    private int id;
    private String names;
    private String dob;
    private int phone_number;
    private int gender;
    private String blood_type;
    private String remarks;
    private boolean status;
    private String formatted_gender;
    private String created_at;

    public Client(int id, String names, String dob, int phone_number, int gender, String blood_type, String remarks, boolean status, String formatted_gender, String created_at) {
        this.id = id;
        this.names = names;
        this.dob = dob;
        this.phone_number = phone_number;
        this.gender = gender;
        this.blood_type = blood_type;
        this.remarks = remarks;
        this.status = status;
        this.formatted_gender = formatted_gender;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFormatted_gender() {
        return formatted_gender;
    }

    public void setFormatted_gender(String formatted_gender) {
        this.formatted_gender = formatted_gender;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", dob='" + dob + '\'' +
                ", phone_number=" + phone_number +
                ", gender=" + gender +
                ", blood_type='" + blood_type + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                ", formatted_gender='" + formatted_gender + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
