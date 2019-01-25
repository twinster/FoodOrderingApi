package com.development.ordering.service;

import com.development.ordering.Globals;
import com.development.ordering.model.Order;
import com.development.ordering.model.OrderDetails;
import com.development.ordering.model.User;
import com.development.ordering.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class OrdersService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Globals globals;

    private User loggedUser;

//todo we dont need orders list
//    public List<Order> getAllOrders() {
//        List<Order> orders = new ArrayList<>();
//        orderRepository.findAll().forEach(orders::add);
//        return orders;
//    }
    
    public Order addOrUpdateOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(String week, long id) {
        return orderRepository.getOrderByUser(id, new Date());
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
