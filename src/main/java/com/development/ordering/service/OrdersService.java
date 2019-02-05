package com.development.ordering.service;

import com.development.ordering.Globals;
import com.development.ordering.model.Order;
import com.development.ordering.model.OrderDetails;
import com.development.ordering.model.User;
import com.development.ordering.repository.OrderRepository;
import com.development.ordering.repository.OrderStatusRepository;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class OrdersService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private Globals globals;

    private User loggedUser;
    
    public Order addOrUpdateOrder(Order order){
        loggedUser = globals.getCurrentUser();
        order.setUser(loggedUser);
        order.getOrderDetails().forEach(orderDetail -> {
            //todo ensure that id while creating object is always null
            if (orderDetail.getOrderStatus().getEnglishName().equals("Confirmed"))
                try {
                    throw new Exception("Order for this day is already confirmed and can not be changed");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (order.getId() == null)
                orderDetail.setOrderStatus(orderStatusRepository.getOrderStatusByEnglishName("Pending"));
        });
        return orderRepository.save(order);
    }

    public Order getOrder(String week) {
        Date date = week.equals("current") ? new Date() : DateUtils.addDays(new Date(), 7);
        loggedUser = globals.getCurrentUser();
        return orderRepository.getOrderByUser(loggedUser.getId(), date);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
