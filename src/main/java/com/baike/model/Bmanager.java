package com.baike.model;

public class Bmanager {
    private Integer bmanagerId;

    private String bmanagerName;

    private String password;

    private Integer state;

    public Integer getBmanagerId() {
        return bmanagerId;
    }

    public void setBmanagerId(Integer bmanagerId) {
        this.bmanagerId = bmanagerId;
    }

    public String getBmanagerName() {
        return bmanagerName;
    }

    public void setBmanagerName(String bmanagerName) {
        this.bmanagerName = bmanagerName == null ? null : bmanagerName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}