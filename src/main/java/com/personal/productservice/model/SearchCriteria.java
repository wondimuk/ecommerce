package com.personal.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Builder
public class SearchCriteria {
    private String productName;
    private ProductCategory category;
    private LocalDate bydate;
    private PageRequest request;

    public SearchCriteria(String productName) {
        this.productName = productName;
    }

    public SearchCriteria(ProductCategory category) {
        this.category = category;
    }

    public SearchCriteria(LocalDate bydate) {
        this.bydate = bydate;
    }

    public SearchCriteria(String productName, ProductCategory category) {
        this.productName = productName;
        this.category = category;
    }

    public SearchCriteria(String productName, LocalDate bydate) {
        this.productName = productName;
        this.bydate = bydate;
    }

    public SearchCriteria(ProductCategory category, LocalDate bydate) {
        this.category = category;
        this.bydate = bydate;
    }
}
