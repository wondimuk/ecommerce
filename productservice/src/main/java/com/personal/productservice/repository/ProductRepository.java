package com.personal.productservice.repository;

import com.personal.productservice.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends MongoRepository<Product,String>,ProductSearchRepository {

}
