package com.example.yeper.yeper.entity;


public class AuthRequest {
    private String uid;
    private String password;

    public AuthRequest(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    public AuthRequest() {
        super();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
