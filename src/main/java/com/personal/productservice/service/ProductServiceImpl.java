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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private final static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO addProduct(ProductDTO product1) throws Exception {
        Product p = productMapper.productMapper(product1);
        Optional<Product> getProduct =productRepository.findByProductCode(product1.getProductCode());
        if(getProduct.isPresent()){
            return updateProduct(product1);
        }else{
            return productMapper.dtoProductMapper(productRepository.save(p));
        }
    }

    @Override
    public ProductDTO findOneProduct(String productCode) throws Exception {
        Product product = productRepository.findByProductCode(productCode).orElseThrow(NoDataFoundError::new); //.orElseThrow(NoDataFoundError::new);
        return productMapper.dtoProductMapper(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product1) throws Exception {
        Product product = productRepository.findByProductCode(product1.getProductCode()).orElseThrow(NoDataFoundError::new);
                //productRepository.findByProductCode(product1.getProductCode()).orElseThrow(NoDataFoundError::new);
        productRepository.delete(product);
        product.setId(product1.getId());
        product.setProductCode(product1.getProductCode());
        product.setProductName(product1.getProductName());
        product.setProductCategory(product1.getProductCategory());
        product.setProductDate(product1.getProductDate());

        productRepository.save(product);
        return productMapper.dtoProductMapper(product);
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
                product.getId(),
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
