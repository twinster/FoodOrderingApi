package com.development.ordering.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private Integer week_num;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "week_day_id", nullable = false)
    private WeekDays weekDays;

    @OneToMany
    private List<Order> orders;

    public Menu() {
    }

    public Menu(String path, Integer week_num) {
        this.setPath(path);
        this.setWeekNum(week_num);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getWeekNum() {
        return week_num;
    }

    public void setWeekNum(Integer week_num) {
        this.week_num = week_num;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
