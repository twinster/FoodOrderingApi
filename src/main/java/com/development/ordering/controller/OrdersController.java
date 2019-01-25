package com.development.ordering.controller;

import com.development.ordering.model.Order;
import com.development.ordering.service.OrdersService;
import com.development.ordering.service.admin.OrderDetailsService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

//todo delete we dont need orders list
//    @RequestMapping(method= RequestMethod.GET, value="/list")
//    public List<Order> getAllOrders() {
//        return ordersService.getAllOrders();
//    }


    @RequestMapping(method=RequestMethod.POST, value="/")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        return ResponseEntity.ok().body(ordersService.addOrUpdateOrder(order));
    }

    @RequestMapping(method=RequestMethod.GET, value="/edit")
    public Order getOrder(@RequestParam String week, @RequestParam long id) throws ResourceNotFoundException {
        return ordersService.getOrder(week, id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public ResponseEntity<Order> updateOrder(@Valid @RequestBody Order order, @PathVariable(value = "id") long id) {
        return  ResponseEntity.ok().body(ordersService.addOrUpdateOrder(order));
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        ordersService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

}
