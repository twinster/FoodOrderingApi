package com.development.ordering.controller;

import com.development.ordering.model.Order;
import com.development.ordering.service.OrdersService;
import com.development.ordering.service.admin.OrderDetailsService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(method= RequestMethod.GET, value="/list")
    public List<Order> getAllOrders() {
        return ordersService.getAllOrders();
    }

    //@Secured("USER")
    @RequestMapping(method=RequestMethod.POST, value="/")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        return ResponseEntity.ok().body(ordersService.addOrUpdateOrder(order));
    }

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER', 'Jemali')")
    @RequestMapping(method=RequestMethod.GET, value="/{id}/edit")
    public Order getOrder(@PathVariable long id) throws ResourceNotFoundException {
        return ordersService.getOrder(id);
    }

    //@PreAuthorize("hasRole('Jemali')")
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
