package com.webshop.webportal.model.order;


public class OrderItem {

    private Long product;
    private int quantity;

    public OrderItem() {
        // empty
    }

    public OrderItem(Long product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
