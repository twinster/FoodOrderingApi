package com.development.ordering.service.admin;

import com.development.ordering.model.OrderDetails;
import com.development.ordering.model.OrderStatus;
import com.development.ordering.repository.OrderDetailsRepository;
import com.development.ordering.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    public OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderStatusRepository orderStatusRepository;

    public List<OrderDetails> getAllNeededOrders(String name) {
        List<OrderDetails> orderDetails = new ArrayList<>();
        OrderStatus orderStatus = orderStatusRepository.getOrderStatusByEnglishName(name);
        orderDetailsRepository.findAllByOrderStatus(orderStatus).forEach(orderDetails::add);
        return orderDetails;
    }

    public OrderDetails getOrderDetail(Long id){
        return orderDetailsRepository.findOrderDetailsById(id);
    }

    public OrderDetails setStatus(Long id, String name) {
        OrderDetails orderDetail = getOrderDetail(id);
        OrderStatus orderStatus = orderStatusRepository.getOrderStatusByEnglishName(name);
        orderDetail.setOrderStatus(orderStatus);
        return orderDetailsRepository.save(orderDetail);
    }
}