package com.personal.productservice.model;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "product")
@Builder
public class Product {
    @Id
    private String productCode;
    private String productName;
    private ProductCategory productCategory;
    private LocalDate date;

    public Product() {}

    public Product(String productCode, String productName, ProductCategory productCategory, LocalDate date) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory=" + productCategory +
                ", date=" + date +
                '}';
    }
}
