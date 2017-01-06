package com.baike.model;

import java.io.Serializable;

/**
 * Created by huanghaojian on 17/1/5.
 */
public class Login implements Serializable {
    private String userName;
    private String password;
    private String validCode;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getValidCode() {
        return validCode;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", validCode='" + validCode + '\'' +
                '}';
    }
}
