package com.webshop.webportal.model.shopping;


import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart implements Serializable {

    private String customerEmail;

    private Map<Long, Integer> items = new TreeMap<>();

    public int addItem(Long productID, int quantity) {
        Integer quan = items.get(productID);
        if (quan == null) {
            items.put(productID, quantity);
            return quantity;
        } else {
            items.put(productID, quan + quantity);
            return quan + quantity;
        }
    }

    public Map<Long, Integer> getItems() {
        return items;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
