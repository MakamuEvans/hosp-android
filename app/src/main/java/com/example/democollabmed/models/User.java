package com.example.democollabmed.models;

public class User {
    private int id;
    private String name;
    private String email;
    private String decoded_user_type;

    public User(int id, String name, String email, String decoded_user_type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.decoded_user_type = decoded_user_type;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDecoded_user_type() {
        return decoded_user_type;
    }

    public void setDecoded_user_type(String decoded_user_type) {
        this.decoded_user_type = decoded_user_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", decoded_user_type='" + decoded_user_type + '\'' +
                '}';
    }
}
