package com.example.democollabmed.models;

public class Drug {
    private int id;
    private String name;
    private int rate;

    public Drug(int id, String name, int rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
