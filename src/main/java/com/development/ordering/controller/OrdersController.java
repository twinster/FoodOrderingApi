package com.development.ordering.controller;

import com.development.ordering.model.Order;
import com.development.ordering.service.OrdersService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(method=RequestMethod.POST, value="/")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        return ResponseEntity.ok().body(ordersService.addOrUpdateOrder(order));
    }

    @RequestMapping(method=RequestMethod.GET, value="/edit")
    public ResponseEntity<Order> getOrder(@RequestParam String week) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(ordersService.getOrder(week));
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
