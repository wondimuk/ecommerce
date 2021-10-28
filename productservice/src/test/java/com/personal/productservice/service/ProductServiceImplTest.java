package com.personal.productservice.service;

import com.personal.productservice.model.Product;
import com.personal.productservice.model.ProductCategory;
import com.personal.productservice.repository.ProductRepository;
import com.personal.productservice.utils.DTO.ProductDTO;
import com.personal.productservice.utils.DTO.ProductMapper;
import com.personal.productservice.utils.DTO.ProductMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

//    private ObjectMapper objectMapper;

    private ProductMapper productMapper=new ProductMapperImpl();

//    @Autowired
//    public void setProductAdapter(@Qualifier("productMapper")ProductMapper productMapper){
//        this.productMapper = productMapper;
//    }

    private ProductDTO product1, product2;
    private Product p1,p2;

    @BeforeEach
    void setup(){
        product1 = ProductDTO.builder()
                .productCode("pr001")
                .productName("Computer")
                .productCategory(ProductCategory.ELECTRONICS)
                .date(LocalDate.now()).build();

        Product p1=productMapper.productMapper(product1);

        product2=ProductDTO.builder()
                .productCode("pr002")
                .productName("Pizza")
                .productCategory(ProductCategory.FOOD)
                .date(LocalDate.now()).build();

        Product p2 = productMapper.productMapper(product2);
    }

//    @Test
//    void shouldReturnProductWhenNewProductAdded(){
////        when(productRepository.save(p1)).thenReturn(p1);
//
//        ProductDTO expected = productService.addProduct(product1);
//
//        System.out.println("Product1 "+product1);
//        System.out.println("Expected "+expected);
//
//        assertEquals(expected.getProductCode(),product1.getProductCode());
//        assertEquals(expected,product1);
//    }
}
