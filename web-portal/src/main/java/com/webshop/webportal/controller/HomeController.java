package com.webshop.webportal.controller;

import com.webshop.webportal.config.CatalogServiceRibbonConfig;
import com.webshop.webportal.model.product.Product;
import com.webshop.webportal.model.product.ProductCategory;
import com.webshop.webportal.model.product.ProductRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("ShoppingCart")
@RibbonClient(name = "catalog-service", configuration = CatalogServiceRibbonConfig.class)
public class HomeController {

    private static final String CAT_SERVICE_BASE_URL = "http://localhost:9000";
//    private static final String CAT_SERVICE_BASE_URL = "http://catalog-service";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "cat", required = false) Long catId) {
        ResponseEntity<Resources<ProductCategory>> categoryEntities = restTemplate.exchange(CAT_SERVICE_BASE_URL + "/categories",
                HttpMethod.GET, null, new ParameterizedTypeReference<Resources<ProductCategory>>() {});
        List<ProductCategory> categories = new ArrayList<>(categoryEntities.getBody().getContent());
        if (catId != null) {
            Optional<ProductCategory> category = categories.stream().filter(cat -> cat.getId() == catId.longValue()).findFirst();
            category.ifPresent(productCategory -> productCategory.setSelected(true));
        }

        String productsUrl = (catId != null) ? CAT_SERVICE_BASE_URL + "/categories/" + catId + "/products" :
                CAT_SERVICE_BASE_URL + "/products";

        ResponseEntity<Resources<Product>> productEntities = restTemplate.exchange(productsUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<Resources<Product>>() {});
        List<Product> products = new ArrayList<>(productEntities.getBody().getContent());
        products.forEach(ProductRegistry::registerProduct);

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "index";
    }
}
