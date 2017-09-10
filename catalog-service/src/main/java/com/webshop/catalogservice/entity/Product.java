package com.webshop.catalogservice.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    private String name;
    private String specs;
    private String imageFile;
    private double price;

    public Product() {
        // needed for JPA
    }

    public Product(ProductCategory category, String name, String specs, String imageFile, double price) {
        this.category = category;
        this.name = name;
        this.specs = specs;
        this.imageFile = imageFile;
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(category)
                .append(name)
                .append(specs)
                .append(imageFile)
                .append(price)
                .hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Product rhs = (Product) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(category, rhs.category)
                .append(name, rhs.name)
                .append(specs, rhs.specs)
                .append(imageFile, rhs.imageFile)
                .append(price, rhs.price)
                .isEquals();
    }
}
