package com.example.democollabmed.models;

public class DoctorDiagnosis {
    private int id;
    private String remarks;
    private User doctor;

    public DoctorDiagnosis(int id, String remarks, User doctor) {
        this.id = id;
        this.remarks = remarks;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "DoctorDiagnosis{" +
                "id=" + id +
                ", remarks='" + remarks + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
