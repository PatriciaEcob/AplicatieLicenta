package com.example.aplicatielicenta.managers;

import androidx.annotation.NonNull;

import com.example.aplicatielicenta.models.SignUpModel;
import com.example.aplicatielicenta.models.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseManager {
    public interface DatabaseManagerCallback {
        void initReady();
    }

    private static final DatabaseManager mInstance = new DatabaseManager();

    private DatabaseReference mUserTableReference;
    private DataSnapshot mUserTableDataSnapshot;

    private int mTablesNumberToGetReady = 1;

    private DatabaseManager() {
        mUserTableReference = FirebaseDatabase.getInstance().getReference("user_table");
    }

    public static DatabaseManager getInstance() {
        return mInstance;
    }

    public void init(final DatabaseManagerCallback callback) {
        mUserTableReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUserTableDataSnapshot = dataSnapshot;
                if(--mTablesNumberToGetReady == 0) {
                    callback.initReady();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public boolean isInitReady() {
        return mTablesNumberToGetReady == 0;
    }

    public void addUser(SignUpModel newUser) {
        mUserTableReference.child(newUser.id).setValue(newUser);
    }

    public void editUser(UserModel user) {
        String password = getUserPassword(user.id);
        SignUpModel editedUser = new SignUpModel(user.id, user.fullName, user.email, password, user.username, user.gender);
        mUserTableReference.child(user.id).setValue(editedUser);
    }

    public void removeUser(String userId) {
        mUserTableReference.child(userId).removeValue();
    }

    public UserModel getUser(String username, String password) {
        for (DataSnapshot node : mUserTableDataSnapshot.getChildren()) {
            String usernameNode = node.child("username").getValue(String.class);
            String passwordNode = node.child("password").getValue(String.class);
            if(username.equals(usernameNode) && password.equals(passwordNode)) {
                return node.getValue(UserModel.class);
            }
        }
        return null;
    }

    public void setKilos(double currentKilo, double goalKilo) {
        mUserTableReference.child(ApplicationManager.getInstance().getUser().id).child("currentKilo").setValue(currentKilo);
        mUserTableReference.child(ApplicationManager.getInstance().getUser().id).child("goalKilo").setValue(goalKilo);
    }

    private String getUserPassword(String userId) {
        for (DataSnapshot node : mUserTableDataSnapshot.getChildren()) {
            String idNode = node.child("id").getValue(String.class);
            if(userId.equals(idNode)) {
                return node.child("password").getValue(String.class);
            }
        }
        return null;
    }
}
