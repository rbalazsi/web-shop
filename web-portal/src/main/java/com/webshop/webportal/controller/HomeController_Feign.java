package com.webshop.webportal.controller;

import com.webshop.webportal.model.product.Product;
import com.webshop.webportal.model.product.ProductCategory;
import com.webshop.webportal.model.product.ProductRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Controller
@SessionAttributes("ShoppingCart")
public class HomeController_Feign {

    @Autowired
    CatalogClient catalogClient;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "cat", required = false) Long catId) {
        List<ProductCategory> categories = new ArrayList<>(catalogClient.getCategories().getContent());
        if (catId != null) {
            Optional<ProductCategory> category = categories.stream().filter(cat -> cat.getId() == catId.longValue()).findFirst();
            category.ifPresent(productCategory -> productCategory.setSelected(true));
        }

        Resources<Product> productsResources = catId != null ? catalogClient.getProductsOfCategory(catId) :
                catalogClient.getAllProducts();

        List<Product> products = new ArrayList<>(productsResources.getContent());
        products.forEach(ProductRegistry::registerProduct);

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "index";
    }
}
