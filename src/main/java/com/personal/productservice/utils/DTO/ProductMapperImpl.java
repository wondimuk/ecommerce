package com.personal.productservice.utils.DTO;
import com.personal.productservice.model.Product;
import org.springframework.stereotype.Service;

@Service
//@Qualifier(value = "productAdapter") //in case if there is another implementation, this will avoid confusion.
public class ProductMapperImpl implements ProductMapper{
    @Override
    public Product productMapper(ProductDTO productDTO) {
        return Product.builder().productCode(productDTO.getProductCode())
                .productName(productDTO.getProductName())
                .productDate(productDTO.getProductDate())
                .productCategory(productDTO.getProductCategory()).build();
    }

    @Override
    public ProductDTO dtoProductMapper(Product product) {
        return ProductDTO.builder()
                .productCode(product.getProductCode())
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .productDate(product.getProductDate())
                .build();
    }
}
