package com.example.tishka;

public class Role {
    private String role, password;

    public Role() {

    }

    public Role(String role, String password) {
        this.role = role;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}