package org.webshop.searchservice.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.webshop.searchservice.entity.ProductCategory;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {

    List<ProductCategory> findByName(@Param("name") String name);
}
