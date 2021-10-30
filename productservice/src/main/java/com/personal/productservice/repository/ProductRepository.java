package com.personal.productservice.repository;

import com.personal.productservice.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository  extends MongoRepository<Product,String> {
    Optional<Product> findByProductCode(String s);
}
