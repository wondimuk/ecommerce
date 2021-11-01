package com.personal.productservice.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "product")
@Builder
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String productCode;
    private String productName;
    private ProductCategory productCategory;
    private LocalDate productDate;

    public Product() {}

    public Product(String productCode, String productName, ProductCategory productCategory, LocalDate productDate) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDate=productDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public LocalDate getProductDate() {
        return productDate;
    }

    public void setProductDate(LocalDate date) {
        this.productDate = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory=" + productCategory +
                ", date=" + getProductDate() +
                '}';
    }
}
