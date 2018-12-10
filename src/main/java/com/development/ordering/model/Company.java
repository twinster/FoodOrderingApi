package com.development.ordering.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "webpage_url")
    private String webPageUrl;

    @OneToMany
    private List<Menu> menus;

    @ManyToMany
    private List<WeekDays> weekDays;

    public Company() {
    }

    public Company(String name, String webpage_url) {
        setName(name);
        setWebPageUrl(webpage_url);
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

    public String getWebPageUrl() {
        return webPageUrl;
    }

    public void setWebPageUrl(String web_page_url) {
        this.webPageUrl = web_page_url;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
