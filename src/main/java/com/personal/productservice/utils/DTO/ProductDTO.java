package com.personal.productservice.utils.DTO;

import com.personal.productservice.model.ProductCategory;
import lombok.*;

import java.time.LocalDate;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDTO {
    private String id;
    private String productCode;
    private String productName;
    private ProductCategory productCategory;
    private LocalDate productDate;
}
