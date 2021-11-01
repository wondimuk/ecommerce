package com.personal.productservice.service;

/*import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.personal.productservice.model.Product;*/
import com.personal.productservice.model.SearchCriteria;
import com.personal.productservice.utils.DTO.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO product1) throws Exception;
    ProductDTO findOneProduct(String productCode) throws Exception;
    ProductDTO updateProduct(ProductDTO product1) throws Exception;
    List<ProductDTO> searchProduct(SearchCriteria searchCriteria);
    Page<ProductDTO> findAllProducts(Pageable page);
//    ProductDTO updatePartialProduct(String productCode, JsonPatch productPath) throws JsonPatchException, JsonProcessingException;
}
