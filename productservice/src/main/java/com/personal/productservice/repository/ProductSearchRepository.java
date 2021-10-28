package com.personal.productservice.repository;

import com.personal.productservice.model.Product;
import com.personal.productservice.model.SearchCriteria;

import java.util.List;


public interface ProductSearchRepository{

    List<Product> products(SearchCriteria searchCriteria);
}
