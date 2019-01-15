package com.development.ordering.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private Integer week_num;

//    @Column(name = "company_id", nullable=false)
//    private Long companyId;

    //@JsonManagedReference
    @JsonIgnoreProperties("menus")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "week_day_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private WeekDays weekDays;

//    @OneToMany
//    private List<OrderDetails> orderDetails;

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

//    public Long getCompanyId() {
//        return companyId;
//    }
//
//    public void setCompanyId(Long companyId) {
//        this.companyId = companyId;
//    }


//    public WeekDays getWeekDays() {
//        return weekDays;
//    }
//
//    public void setWeekDays(WeekDays weekDays) {
//        this.weekDays = weekDays;
//    }

}
