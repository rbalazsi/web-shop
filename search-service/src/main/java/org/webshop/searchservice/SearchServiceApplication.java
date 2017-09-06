package org.webshop.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.webshop.searchservice.entity.Product;
import org.webshop.searchservice.entity.ProductCategory;
import org.webshop.searchservice.repository.ProductCategoryRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SearchServiceApplication implements CommandLineRunner {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }

    //TODO: parameterize it so these are generated only on -Ddatagen parameter (and use a persistent store like PostgreSQL)
    @Override
    public void run(String... args) throws Exception {
        ProductCategory laptopsCategory = new ProductCategory("Laptops");
        Set<Product> laptops = new HashSet<Product>() {{
            add(new Product(laptopsCategory, "ASUS A556UQ-DM943D i7", 2499.99));
            add(new Product(laptopsCategory, "ASUS X556UQ-DM480D i7", 2799.99));
            add(new Product(laptopsCategory, "ASUS A550VX-XX326D", 2899.99));
        }};
        laptopsCategory.setProducts(laptops);

        ProductCategory graphicsCardsCategory = new ProductCategory("Graphics cards");
        Set<Product> graphicsCards = new HashSet<Product>() {{
            add(new Product(laptopsCategory, "ASUS nVidia GeForce 210", 179.99));
            add(new Product(laptopsCategory, "GIGABYTE GeForce GTX 1060", 1179.99));
            add(new Product(laptopsCategory, "ASUS AMD Radeon RX 460", 529.99));
        }};
        graphicsCardsCategory.setProducts(graphicsCards);

        categoryRepository.save(new HashSet<ProductCategory>() {{
            add(laptopsCategory);
            add(graphicsCardsCategory);
        }});
    }
}
