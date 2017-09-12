package com.webshop.webportal.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.webshop.webportal.controller.OrderClient;
import com.webshop.webportal.model.order.Order;
import com.webshop.webportal.model.order.OrderItem;
import com.webshop.webportal.model.shopping.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService_Feign {

    @Autowired
    private OrderClient orderClient;

    @HystrixCommand(fallbackMethod = "fallbackOnOrderFailure")
    public Order postOrderFromShoppingCart(ShoppingCart cart) {
        Order order = buildOrderFromShoppingCart(cart);
        Resource<Order> orderResource = orderClient.placeOrder(order);
        return orderResource.getContent();
    }

    public Order fallbackOnOrderFailure(ShoppingCart cart) {
        return null;
    }

    private Order buildOrderFromShoppingCart(ShoppingCart cart) {
        Order order = new Order();
        order.setCustomerEmail(cart.getCustomerEmail());
        List<OrderItem> orderItems = cart.getItems()
                .entrySet()
                .stream()
                .map(entry -> new OrderItem(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        order.setItems(orderItems);
        return order;
    }
}
