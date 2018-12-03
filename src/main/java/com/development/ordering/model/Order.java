package com.development.ordering.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date order_date;
    private Integer week_num;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany
    private List<OrderDetails> orderDetails;

    public Order() {}

    public Order(Date order_date, Integer week_num) {
        this.order_date = order_date;
        this.week_num = week_num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Integer getWeek_number() {
        return week_num;
    }

    public void setWeek_number(Integer week_number) {
        this.week_num = week_num;
    }
}
