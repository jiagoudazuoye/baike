package com.baike.model;

import java.io.Serializable;
import java.io.StreamCorruptedException;

/**
 * Created by huanghaojian on 17/1/5.
 */
public class Register implements Serializable {
    private String userName;
    private String password;
    private String email;
    private String vaildCode;

    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setVaildCode(String vaildCode){
        this.vaildCode=vaildCode;
    }
    public String getValidCode(){return vaildCode;}
}
