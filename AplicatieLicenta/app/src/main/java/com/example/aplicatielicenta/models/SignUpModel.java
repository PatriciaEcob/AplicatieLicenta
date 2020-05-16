package com.example.aplicatielicenta.models;

import com.google.firebase.database.PropertyName;

public class SignUpModel {
    @PropertyName("id")
    public String id;
    @PropertyName("fullName")
    public String fullName;
    @PropertyName("username")
    public String username;
    @PropertyName("email")
    public String email;
    @PropertyName("password")
    public String password;
    @PropertyName("gender")
    public int gender;

    public SignUpModel() {
    }

    public SignUpModel(String id, String fullName, String email, String password, String username, int gender) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.gender = gender;
    }
}
