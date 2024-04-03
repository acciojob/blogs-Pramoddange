package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String password;
    String userName;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Blog> arr;

    public User(){
        arr=new ArrayList<>();
    }
    public User(String x, String y){
        userName=x;
        password=y;
        arr=new ArrayList<>();
    }

    public User(Integer userId) {
        arr=new ArrayList<>();
        id=userId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Blog> getArr() {
        return arr;
    }

    public void setArr(List<Blog> arr) {
        this.arr = arr;
    }
}