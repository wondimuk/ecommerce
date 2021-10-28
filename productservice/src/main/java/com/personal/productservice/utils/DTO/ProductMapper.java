package com.personal.productservice.utils.DTO;

import com.personal.productservice.model.Product;

public interface ProductMapper {
    Product productMapper(ProductDTO productDTO);
    ProductDTO dtoProductMapper(Product product);
}
