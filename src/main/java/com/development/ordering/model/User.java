package com.development.ordering.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    @Column(unique = true)
    private String email;
    private String phone_number;
    @Column(unique = true)
    private String username;
    //@JsonIgnore
    private String password;
    @ManyToOne
    @JoinColumn(name="role_id", nullable = false)
    private UserRole userRole;
    @Transient
    private String token;

    @OneToMany
    private List<Order> orders;

    @OneToMany
    private List<Order> confirmedOrders; //??

    public User(){}

    public User(String name, String position, String email, String phone_number, String username, String password) {
        super();
        this.name = name;

        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
    }

    public User(String name, String position, String email, String phone_number, String username, String password, UserRole userRole) {
        super();
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user_name) {
        this.username = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
