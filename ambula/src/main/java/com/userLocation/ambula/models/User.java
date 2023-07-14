package com.userLocation.ambula.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.userLocation.ambula.services.User_type;
import lombok.Data;

import javax.persistence.*;

//This user class or tables which is used to register user.
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(unique = true)
    private  String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;

    private User_type user_type;


//    Constructers

    public User(String name, String password) {
        this.name=name;
        this.password=password;
    }
    public User() {

    }

//    Getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User_type getUser_type() {
        return user_type;
    }

    public void setUser_type(User_type user_type) {
        this.user_type = user_type;
    }
}
