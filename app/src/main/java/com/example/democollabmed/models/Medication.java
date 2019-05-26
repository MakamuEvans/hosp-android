package com.example.democollabmed.models;

public class Medication {
    private int id;
    private String remarks;
    private Drug drug;

    public Medication(int id, String remarks, Drug drug) {
        this.id = id;
        this.remarks = remarks;
        this.drug = drug;
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

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", remarks='" + remarks + '\'' +
                ", drug=" + drug +
                '}';
    }
}
