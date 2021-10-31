package com.personal.productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
/*import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Qualifier;*/

import com.personal.productservice.service.ProductService;
import com.personal.productservice.utils.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
//    @Qualifier("productServiceImpl")
    private ProductService productService;
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllProducts(Pageable page) throws Exception {
        Page<ProductDTO> product = productService.findAllProducts(page);
        return new ResponseEntity(product,HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) throws Exception {
        ProductDTO prod = productService.addProduct(product);
        return new ResponseEntity(prod, HttpStatus.ACCEPTED);
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
/*    @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<ProductDTO> updatePartialProduct(@PathVariable String productCode, @Valid @RequestBody JsonPatch productPatch) throws JsonPatchException, JsonProcessingException {
        return new ResponseEntity(productService.updatePartialProduct(productCode,productPatch), HttpStatus.ACCEPTED);
    }*/
//    @GetMapping
//    public ResponseEntity<List<ProductDTO>> searchProduct(
//            @RequestParam(required = false) String productName,
//            @RequestParam(required = false) ProductCategory category){
//        SearchCriteria searchCriteria=SearchCriteria.builder().productName(productName).category(category).build();
//        List<ProductDTO> product = productService.searchProduct(searchCriteria);
//        return new ResponseEntity(product,HttpStatus.FOUND);
//    }


}
