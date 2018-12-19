package com.development.ordering.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private Integer week_num;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Company.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "week_day_id", referencedColumnName = "id")
    private WeekDays weekDays;

    public Menu() {
    }

    public Menu(String path, Integer week_num, Long company_id) {
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

    public WeekDays getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(WeekDays weekDays) {
        this.weekDays = weekDays;
    }

}
