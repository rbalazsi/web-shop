package com.webshop.catalogservice.repository;


import com.webshop.catalogservice.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findByName(@Param("name") String name);

    @Query("select p from Product p where p.category.id = :category")
    List<Product> findByCategory(@Param("category") long categoryId);
}
