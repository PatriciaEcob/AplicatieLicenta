package com.example.aplicatielicenta.models;

import com.google.firebase.database.PropertyName;

public class UserModel {
    @PropertyName("id")
    public String id;
    @PropertyName("fullName")
    public String fullName;
    @PropertyName("username")
    public String username;
    @PropertyName("email")
    public String email;
    @PropertyName("gender")
    public int gender;
    @PropertyName("currentKilo")
    public double currentKilo;
    @PropertyName("goalKilo")
    public double goalKilo;

    public UserModel() {
    }

    public UserModel(String id, String fullName, String email, String username, int gender) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.gender = gender;
        currentKilo = -1;
        goalKilo = -1;
    }
}
