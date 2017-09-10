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
            add(new Product(laptopsCategory, "ASUS A556UQ-DM943D i7", "Intel® Core™ i7-7500U 2.70GHz, Kaby Lake™, 15.6\", 4GB, 1TB, DVD-RW, nVIDIA GeForce 940MX 2GB, Free DOS, Gray",
                    "A556UQ-DM943D_i7.jpg", 2499.99));
            add(new Product(laptopsCategory, "ASUS X556UQ-DM480D i7", "Intel® Core™ i7-7500U 2.70 GHz, Kaby Lake™, 15.6\" Full HD, 8GB, 1TB, DVD-RW, nVidia GeForce 940MX 2GB, Free DOS, Dark Brown",
                    "X556UQ-DM480D_i7.jpg", 2799.99));
            add(new Product(laptopsCategory, "ASUS A550VX-XX326D i7", "Intel® Core™ i7-6700HQ 2.60GHz, Skylake™, 15.6\", 4GB, 1TB, DVD-RW, nVIDIA GeForce GTX 950M 2GB, Free DOS, Gray",
                    "A550VX-XX326D_i7.jpg", 2899.99));
        }};
        laptopsCategory.setProducts(laptops);

        ProductCategory graphicsCardsCategory = new ProductCategory("Graphics cards");
        Set<Product> graphicsCards = new HashSet<Product>() {{
            add(new Product(graphicsCardsCategory, "ASUS nVidia GeForce 210", "ASUS GeForce® GT 210, 1GB DDR3, 64-bit, 2560 x 1600",
                    "ASUS_nVidia_GeForce_210.jpg", 179.99));
            add(new Product(graphicsCardsCategory, "GIGABYTE GeForce GTX 1060", "GIGABYTE GeForce® GTX 1060 WINDFORCE 2, 3GB GDDR5, 192-bit, 7680 x 4320",
                    "GIGABYTE_GeForce_GTX_1060.jpg", 1179.99));
            add(new Product(graphicsCardsCategory, "ASUS AMD Radeon RX 460", "ASUS AMD Radeon RX 460, 2GB GDDR5, 128-bit, 5120 x 2880",
                    "ASUS_AMD_Radeon_RX_460.jpg", 529.99));
        }};
        graphicsCardsCategory.setProducts(graphicsCards);

        categoryRepository.save(new HashSet<ProductCategory>() {{
            add(laptopsCategory);
            add(graphicsCardsCategory);
        }});
    }
}
