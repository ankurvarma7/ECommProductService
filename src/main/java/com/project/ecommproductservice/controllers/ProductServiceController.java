package com.project.ecommproductservice.controllers;

import com.project.ecommproductservice.dtos.ProductServiceRequestDto;
import com.project.ecommproductservice.dtos.ProductServiceResponseDto;
import com.project.ecommproductservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductServiceController {
    private ProductService productService;

    public ProductServiceController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductServiceResponseDto>> getProducts(){
        List<ProductServiceResponseDto> responseDtos=productService.getProducts();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductServiceResponseDto> getProductById(@PathVariable("id") int id){
        ProductServiceResponseDto responseDto=productService.getProductById(id);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductServiceResponseDto> addProduct(ProductServiceRequestDto productServiceRequestDto){
        ProductServiceResponseDto productServiceResponseDto=productService.addProduct(productServiceRequestDto);
        return ResponseEntity.ok(productServiceResponseDto);
    }
//    @PatchMapping("/products/{id}")
//    public ResponseEntity<ProductServiceResponseDto> updateProduct(@PathVariable("id") int id,ProductServiceRequestDto productServiceRequestDto){
//        productService
//    }

}
