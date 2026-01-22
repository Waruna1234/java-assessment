package com.example.Assessment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private int id;
    private String userName;
    private String password;

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setPassword(String password){
        this.password =password;
    }
    public String getPassword(){
        return password;
    }

    public User(int id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password =password;
    }
    public User(){}
    


    
}
