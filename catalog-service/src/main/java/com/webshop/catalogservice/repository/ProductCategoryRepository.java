package com.webshop.catalogservice.repository;


import com.webshop.catalogservice.entity.ProductCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {

    List<ProductCategory> findByName(@Param("name") String name);
}
