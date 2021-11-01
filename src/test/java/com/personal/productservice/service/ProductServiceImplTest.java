package com.personal.productservice.service;

import com.personal.productservice.model.Product;
import com.personal.productservice.model.ProductCategory;
import com.personal.productservice.repository.ProductRepository;
import com.personal.productservice.utils.DTO.ProductDTO;
import com.personal.productservice.utils.DTO.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    private ProductDTO product1, product2;
    private Product p1,p2;

    @BeforeEach
    void setup(){
        product1 = ProductDTO.builder()
                .productCode("pr001")
                .productName("Computer")
                .productCategory(ProductCategory.ELECTRONICS)
                .productDate(LocalDate.now()).build();

        p1 = Product.builder()
                .productCode("pr001")
                .productName("Computer")
                .productCategory(ProductCategory.ELECTRONICS)
                .productDate(LocalDate.now()).build();

        product2=ProductDTO.builder()
                .productCode("pr002")
                .productName("Pizza")
                .productCategory(ProductCategory.FOOD)
                .productDate(LocalDate.now()).build();

        p2=Product.builder()
                .productCode("pr002")
                .productName("Pizza")
                .productCategory(ProductCategory.FOOD)
                .productDate(LocalDate.now()).build();
    }

    @Test
    void shouldReturnProductWhenNewProductAdded() throws Exception {
        when(productRepository.save(p1)).thenReturn(p1);
        when(productMapper.productMapper(product1)).thenReturn(p1);
        when(productMapper.dtoProductMapper(p1)).thenReturn(product1);

        ProductDTO expected = productServiceImpl.addProduct(product1);

        assertEquals(expected.getProductCode(),product1.getProductCode());
        assertEquals(expected,product1);
    }
}
