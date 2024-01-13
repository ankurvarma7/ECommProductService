package com.project.ecommproductservice.services;

import com.project.ecommproductservice.dtos.ProductServiceRequestDto;
import com.project.ecommproductservice.dtos.ProductServiceResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Override
    public ProductServiceResponseDto getProductById(int id) {
        return null;
    }

    @Override
    public List<ProductServiceResponseDto> getProducts() {
        return null;
    }

    @Override
    public ProductServiceResponseDto addProduct(ProductServiceRequestDto productServiceRequestDto) {
        return null;
    }

    @Override
    public ProductServiceResponseDto updateProduct(ProductServiceRequestDto productServiceRequestDto) {
        return null;
    }
}
