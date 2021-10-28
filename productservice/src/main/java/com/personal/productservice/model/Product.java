package com.personal.productservice.model;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(value = "Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String productCode;
    private String productName;
    private ProductCategory productCategory;
    private LocalDate date;
}
