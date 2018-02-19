package com.example.parkminhyun.wannafootball.screen.register;

/**
 * Created by ParkMinHyun on 2018-02-15.
 * 현재 사용하지 않는 Class 추후 참고를 위해 남겨놓음.
 */

public class RegisterPageModel {

    private String email;
    private String password;

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

    @Override
    public String toString() {
        return "RegisterPageModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
