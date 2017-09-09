package com.webshop.catalogservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.webshop.catalogservice.entity.Product;
import com.webshop.catalogservice.entity.ProductCategory;
import com.webshop.catalogservice.repository.ProductCategoryRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Fills the database with dummy data.
 */
@Component
public class DummyDataGenerator {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    public void generateAndSave() {
        ProductCategory laptopsCategory = new ProductCategory("Laptops");
        Set<Product> laptops = new HashSet<Product>() {{
            add(new Product(laptopsCategory, "ASUS A556UQ-DM943D i7", 2499.99));
            add(new Product(laptopsCategory, "ASUS X556UQ-DM480D i7", 2799.99));
            add(new Product(laptopsCategory, "ASUS A550VX-XX326D", 2899.99));
        }};
        laptopsCategory.setProducts(laptops);

        ProductCategory graphicsCardsCategory = new ProductCategory("Graphics cards");
        Set<Product> graphicsCards = new HashSet<Product>() {{
            add(new Product(graphicsCardsCategory, "ASUS nVidia GeForce 210", 179.99));
            add(new Product(graphicsCardsCategory, "GIGABYTE GeForce GTX 1060", 1179.99));
            add(new Product(graphicsCardsCategory, "ASUS AMD Radeon RX 460", 529.99));
        }};
        graphicsCardsCategory.setProducts(graphicsCards);

        categoryRepository.save(new HashSet<ProductCategory>() {{
            add(laptopsCategory);
            add(graphicsCardsCategory);
        }});
    }
}
