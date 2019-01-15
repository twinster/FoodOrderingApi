package com.development.ordering.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicUpdate;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "companies")
@DynamicUpdate
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "webpage_url")
    private String webPageUrl;

    @JsonIgnoreProperties("company")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "company_id", nullable=false)
    private Set<Menu> menus;

    @ManyToMany
    private List<WeekDays> weekDays;

    public Company() {
    }

    public Company(String name, String webpage_url) {
        setName(name);
        setWebPageUrl(webpage_url);
    }

    public Company(String name, String webpage_url, Set<Menu> menus, List<WeekDays> weekDays){
        this.name = name;
        this.webPageUrl = webpage_url;
        this.menus = menus;
        this.weekDays = weekDays;
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

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
