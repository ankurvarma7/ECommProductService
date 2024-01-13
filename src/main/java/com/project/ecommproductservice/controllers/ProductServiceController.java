package com.project.ecommproductservice.controllers;

import com.project.ecommproductservice.dtos.ProductServiceResponseDto;
import com.project.ecommproductservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductServiceController {
    private ProductService productService;

    public ProductServiceController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public ResponseEntity getProducts(){
        List<ProductServiceResponseDto> responseDtos=productService.getProducts();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        ProductServiceResponseDto responseDto=productService.getProductById(id);
        return ResponseEntity.ok(responseDto);
    }

}
