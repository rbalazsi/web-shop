package com.webshop.webportal.model.order;


import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customerEmail;
    private List<OrderItem> items = new ArrayList<>();


    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
