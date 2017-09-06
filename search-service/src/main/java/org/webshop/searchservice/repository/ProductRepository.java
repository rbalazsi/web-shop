package org.webshop.searchservice.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.webshop.searchservice.entity.Product;
import org.webshop.searchservice.entity.ProductCategory;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findByName(@Param("name") String name);

    List<Product> findByCategory(@Param("category") ProductCategory category);
}
