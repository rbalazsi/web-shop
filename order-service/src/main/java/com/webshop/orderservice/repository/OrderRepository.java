package com.webshop.orderservice.repository;


import com.webshop.orderservice.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByCustomerEmail(@Param("customerEmail") String customerEmail);
}
