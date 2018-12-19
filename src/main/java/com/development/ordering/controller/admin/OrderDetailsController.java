package com.development.ordering.controller.admin;

import com.development.ordering.model.Order;
import com.development.ordering.model.OrderDetails;
import com.development.ordering.service.admin.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Parameter;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin/orders")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService ordersService;

    @RequestMapping(method= RequestMethod.GET, value="/list")
    public List<OrderDetails> getAllPendingOrders(@RequestParam String name) {
        return ordersService.getAllNeededOrders(name);
    }

    @RequestMapping(method= RequestMethod.GET, value="/set_status/{id}")
    public OrderDetails setStatus(@RequestParam String name, @PathVariable Long id){
        return ordersService.setStatus(id, name);
    }
}
