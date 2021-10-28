package com.personal.productservice.controller;

import com.personal.productservice.model.Product;
import com.personal.productservice.model.ProductCategory;
import com.personal.productservice.model.SearchCriteria;
import com.personal.productservice.service.ProductService;
import com.personal.productservice.utils.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product){
        ProductDTO product1 = productService.addProduct(product);
        return new ResponseEntity(product1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDTO> findOneProduct(@PathVariable String productCode) throws Exception {
        ProductDTO product = productService.findOneProduct(productCode);
        return new ResponseEntity(product,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product) throws Exception {
        ProductDTO productDTO = productService.updateProduct(product);
        return new ResponseEntity(productDTO,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> searchProduct(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) ProductCategory category){
        SearchCriteria searchCriteria=SearchCriteria.builder().productName(productName).category(category).build();
        List<ProductDTO> product = productService.searchProduct(searchCriteria);
        return new ResponseEntity(product,HttpStatus.FOUND);
    }


}
