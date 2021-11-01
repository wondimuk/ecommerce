package com.personal.productservice.repository;

import com.personal.productservice.model.Product;
import com.personal.productservice.model.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class CustomProductSearchRepository implements ProductSearchRepository{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> products(SearchCriteria searchCriteria) {
         Query query = new Query(); //.with(searchCriteria.getRequest())

        final List<Criteria> criteria = new ArrayList();
        if(searchCriteria.getProductName()!=null && !searchCriteria.getProductName().isEmpty())
            criteria.add(Criteria.where("productName").is(searchCriteria.getProductName()));
        if(searchCriteria.getCategory()!=null && !searchCriteria.getCategory().name().isEmpty())
            criteria.add(Criteria.where("category").is(searchCriteria.getCategory()));
        if(searchCriteria.getBydate()!=null && searchCriteria.getBydate().isEqual(LocalDate.of(1900,01,01)))
            criteria.add(Criteria.where("date").is(searchCriteria.getBydate()));
        if(!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
            return mongoTemplate.find(query,Product.class);
    }
}
