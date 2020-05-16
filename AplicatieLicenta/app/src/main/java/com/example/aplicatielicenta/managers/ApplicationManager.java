package com.example.aplicatielicenta.managers;

import com.example.aplicatielicenta.models.UserModel;

public class ApplicationManager {
    private static final ApplicationManager mInstance = new ApplicationManager();

    private UserModel mUser;

    private ApplicationManager() {
    }

    public static ApplicationManager getInstance() {
        return mInstance;
    }

    public void setUser(UserModel user) {
        mUser = user;
    }

    public UserModel getUser() {
        return mUser;
    }
}
