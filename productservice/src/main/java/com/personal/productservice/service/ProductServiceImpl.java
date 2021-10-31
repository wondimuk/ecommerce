package com.personal.productservice.service;

/*import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;*/
import com.personal.productservice.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.productservice.model.SearchCriteria;
import com.personal.productservice.repository.ProductRepository;
import com.personal.productservice.utils.DTO.ProductDTO;
import com.personal.productservice.utils.DTO.ProductMapper;
import com.personal.productservice.utils.DTO.exception.NoDataFoundError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@Qualifier("productServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO addProduct(ProductDTO product1) {
        Product p = productRepository.save(productMapper.productMapper(product1));
        ProductDTO pp = productMapper.dtoProductMapper(p);
        return pp;
    }

    @Override
    public ProductDTO findOneProduct(String productCode) throws Exception {
        Product product = productRepository.findByProductCode(productCode).get(); //.orElseThrow(NoDataFoundError::new);
        return productMapper.dtoProductMapper(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product1) {
        Product product = productRepository.findById(product1.getProductCode()).orElseThrow(NoDataFoundError::new);
        Product updateProduct = new Product();
        updateProduct.setProductCode(product.getProductCode());
        updateProduct.setProductName(product.getProductName());
        updateProduct.setProductCategory(product.getProductCategory());
        updateProduct.setDate(product.getProductDate());
        productRepository.save(updateProduct);
        return productMapper.dtoProductMapper(updateProduct);
    }

    @Override
    public List<ProductDTO> searchProduct(SearchCriteria searchCriteria) {
//        List<Product> products =  productRepository.products(searchCriteria);
//         List<ProductDTO> productDTOS=products.stream().map(product -> productMapper.dtoProductMapper(product)).collect(Collectors.toList());
//        return productDTOS;
        return new ArrayList<ProductDTO>();
    }

    @Override
    public Page<ProductDTO> findAllProducts(Pageable page) {
        Page<Product> p = productRepository.findAll(page);
        return new PageImpl<ProductDTO>(p.getContent().stream().map(product -> new ProductDTO(
                product.getProductCode(),
                product.getProductName(),
                product.getProductCategory(),
                product.getProductDate()
        )).collect(Collectors.toList()), page, p.getTotalPages());
    }

//    @Override
//    public ProductDTO updatePartialProduct(String productCode, JsonPatch productPatch) throws JsonPatchException, JsonProcessingException {
//        Product product = productRepository.findById(productCode).orElseThrow(NoDataFoundError::new);
//        Product updatedProduct = applyPatchToProduct(productPatch, product);
//        productRepository.save(updatedProduct);
//        return productMapper.dtoProductMapper(updatedProduct);
//    }
//
//    private Product applyPatchToProduct(JsonPatch productPatch, Product product) throws JsonPatchException, JsonProcessingException {
//        JsonNode patchedProduct = productPatch.apply(objectMapper.convertValue(product, JsonNode.class));
//        return objectMapper.treeToValue(patchedProduct, Product.class);
//    }


}
