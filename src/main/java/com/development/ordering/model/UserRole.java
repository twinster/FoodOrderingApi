package com.development.ordering.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<User> users;

    public UserRole() {}

    public UserRole(String name) {
        super();
        this.name = name;
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

    public List<User> getUserAcounts() {
        return users;
    }

    public void setUserAcounts(List<User> users) {
        this.users = users;
    }

}
