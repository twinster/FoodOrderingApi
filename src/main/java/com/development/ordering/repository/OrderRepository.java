package com.development.ordering.repository;

import com.development.ordering.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    public Order getOrderById(Long id);
}
