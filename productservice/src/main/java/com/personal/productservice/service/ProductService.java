package com.personal.productservice.service;

import com.personal.productservice.model.SearchCriteria;
import com.personal.productservice.utils.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO product1) ;

    ProductDTO findOneProduct(String productCode) throws Exception;

    ProductDTO updateProduct(ProductDTO product1) throws Exception;

    List<ProductDTO> searchProduct(SearchCriteria searchCriteria);
}
