package com.development.ordering.controller;

import com.development.ordering.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

//    @RequestMapping(method= RequestMethod.GET, value="/")
//    public List<Order> getAllOrders() {
//        return ordersService.getAllOrders();
//    }
//
//    @RequestMapping(method= RequestMethod.GET, value="/delete")
//    public List<Order> getAllOrders() {
//        return ordersService.getAllOrders();
//    }

}
