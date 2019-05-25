package com.example.democollabmed.models;

public class RadiologyDiagnosis {
    private int id;
    private int check_in_id;
    private String remarks;
    private User technician;
    private Test test;

    public RadiologyDiagnosis(int id, int check_in_id, String remarks, User technician, Test test) {
        this.id = id;
        this.check_in_id = check_in_id;
        this.remarks = remarks;
        this.technician = technician;
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheck_in_id() {
        return check_in_id;
    }

    public void setCheck_in_id(int check_in_id) {
        this.check_in_id = check_in_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User getTechnician() {
        return technician;
    }

    public void setTechnician(User technician) {
        this.technician = technician;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "LabDiagnosis{" +
                "id=" + id +
                ", check_in_id=" + check_in_id +
                ", remarks='" + remarks + '\'' +
                ", technician=" + technician +
                ", test=" + test +
                '}';
    }
}
