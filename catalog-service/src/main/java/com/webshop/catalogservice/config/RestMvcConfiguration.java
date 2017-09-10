package com.webshop.catalogservice.config;

import com.webshop.catalogservice.entity.Product;
import com.webshop.catalogservice.entity.ProductCategory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Component
@EnableWebMvc
public class RestMvcConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Product.class, ProductCategory.class);
    }
}