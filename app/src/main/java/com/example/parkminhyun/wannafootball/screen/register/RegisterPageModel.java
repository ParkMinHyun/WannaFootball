package com.example.parkminhyun.wannafootball.screen.register;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class RegisterPageModel {

    private String email;
    private String password;
    private String passwordCheck;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    @Override
    public String toString() {
        return "RegisterPageModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordCheck='" + passwordCheck + '\'' +
                '}';
    }
}
