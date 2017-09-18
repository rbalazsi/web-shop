package com.webshop.webportal.controller;

import com.webshop.webportal.model.product.Product;
import com.webshop.webportal.model.product.ProductCategory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("http://catalog-service")
public interface CatalogClient {

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/api/categories")
    Resources<ProductCategory> getCategories();

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/api/products")
    Resources<Product> getAllProducts();

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/api/categories/{catId}/products")
    Resources<Product> getProductsOfCategory(@PathVariable("catId") Long categoryId);
}
