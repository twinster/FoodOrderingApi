package com.development.ordering.repository;

import com.development.ordering.model.OrderDetails;
import com.development.ordering.model.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {
    public List<OrderDetails> findAllByOrderStatus(OrderStatus o);
    public OrderDetails findOrderDetailsById(Long id);
}
