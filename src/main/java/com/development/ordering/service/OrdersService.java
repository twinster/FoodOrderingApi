package com.development.ordering.service;

import com.development.ordering.model.Company;
import com.development.ordering.model.Order;
import com.development.ordering.model.OrderDetails;
import com.development.ordering.repository.OrderRepository;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import static com.development.ordering.model.Constants.CURRENT_AUTH;

@Service
public class OrdersService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }
    
    public Order addOrUpdateOrder(Order order) {
        List<OrderDetails> orderDetails = order.getOrderDetails();
        orderDetails.forEach(orderDetail -> {
            orderDetail.setOrder(order);
        });
        order.setOrderDetails(orderDetails);
        return orderRepository.save(order);
    }

    public Order getOrder(long id) {
        return orderRepository.getOrderById(id);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
