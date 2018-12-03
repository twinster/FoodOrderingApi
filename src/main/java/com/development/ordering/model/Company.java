package com.development.ordering.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String webpage_url;

    @OneToMany
    private List<Menu> menus;

    @ManyToMany
    private List<WeekDays> weekDays;

    public Company() {
    }

    public Company(String name, String webpage_url) {
        setName(name);
        setWebpageUrl(webpage_url);
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

    public String getWebpageUrl() {
        return webpage_url;
    }

    public void setWebpageUrl(String web_page_url) {
        this.webpage_url = web_page_url;
    }
}
