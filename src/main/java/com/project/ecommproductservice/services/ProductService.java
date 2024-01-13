package com.project.ecommproductservice.services;

import com.project.ecommproductservice.dtos.ProductServiceRequestDto;
import com.project.ecommproductservice.dtos.ProductServiceResponseDto;

import java.util.List;

public interface ProductService {
    public ProductServiceResponseDto getProductById(int id);
    public List<ProductServiceResponseDto> getProducts();
    public ProductServiceResponseDto addProduct(ProductServiceRequestDto productServiceRequestDto);
    public ProductServiceResponseDto updateProduct(ProductServiceRequestDto productServiceRequestDto);
}
