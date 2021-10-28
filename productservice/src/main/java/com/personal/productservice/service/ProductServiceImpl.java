package com.personal.productservice.service;

import com.personal.productservice.model.Product;
import com.personal.productservice.model.SearchCriteria;
import com.personal.productservice.repository.ProductRepository;
import com.personal.productservice.utils.DTO.ProductDTO;
import com.personal.productservice.utils.DTO.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO addProduct(ProductDTO product1) {
       Product test= productMapper.productMapper(product1);
        Product p = productRepository.save(test);
        ProductDTO pp = productMapper.dtoProductMapper(p);
        return pp;
    }

    @Override
    public ProductDTO findOneProduct(String productCode) throws Exception {
        Optional<Product> product = productRepository.findById(productCode);
        if(product.isPresent()){
            return productMapper.dtoProductMapper(product.get());
        }
        throw new Exception();
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product1) throws Exception {
        Optional<Product> product = productRepository.findById(product1.getProductCode());
        if(product.isPresent()){
            Product updateProduct = new Product();
            updateProduct.setProductCode(product.get().getProductCode());
            updateProduct.setProductName(product.get().getProductName());
            updateProduct.setProductCategory(product.get().getProductCategory());
            updateProduct.setDate(product.get().getDate());

            productRepository.save(updateProduct);

            return productMapper.dtoProductMapper(updateProduct);
        }
        throw new Exception();
    }

    @Override
    public List<ProductDTO> searchProduct(SearchCriteria searchCriteria) {
        List<Product> products =  productRepository.products(searchCriteria);
         List<ProductDTO> productDTOS=products.stream().map(product -> productMapper.dtoProductMapper(product)).collect(Collectors.toList());
        return productDTOS;
    }


}
