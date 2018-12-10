package com.development.ordering.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "week_days")
public class WeekDays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String day;
    private String englishName;

    @OneToMany
    public List<Menu> menus;

    @OneToMany
    public List<OrderDetails> orderDetails;

    @ManyToMany(mappedBy="weekDays")
    private List<Company> companies;

    public WeekDays(){}

    private WeekDays(String day, String englishName) {
        this.day = day;
        this.englishName = englishName;
    }

    public Integer getId() {
        return id;
    }

    public String getWeekDay() {
        return day;
    }

    public String getEnglishName() {
        return englishName;
    }
}
