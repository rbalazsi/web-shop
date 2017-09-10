package com.webshop.webportal.model.product;

import java.util.HashMap;
import java.util.Map;

public class ProductRegistry {

    private static Map<Long, Product> productLookup = new HashMap<>();

    public static void registerProduct(Product product) {
        productLookup.put(product.getId(), product);
    }

    public static Product lookupProduct(Long id) {
        return productLookup.get(id);
    }
}
