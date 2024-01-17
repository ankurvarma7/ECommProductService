package com.project.ecommproductservice.client;

import com.project.ecommproductservice.dtos.FakeStoreProductRequestDto;
import com.project.ecommproductservice.dtos.FakeStoreProductResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreProductClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreUrl;
    private String fakeStorePathProducts;
    private String fakeStorePathCategory;

    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreUrl,@Value("${fakestore.api.path.products}") String fakeStorePathProducts,@Value("${fakestore.api.path.category}") String fakeStorePathCategory) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreUrl = fakeStoreUrl;
        this.fakeStorePathProducts = fakeStorePathProducts;
        this.fakeStorePathCategory = fakeStorePathCategory;
    }

    public FakeStoreProductResponseDto getProductbyId(int id){
        String productUrl=fakeStoreUrl+fakeStorePathProducts+"/"+id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto> productResponse=restTemplate.getForEntity(productUrl, FakeStoreProductResponseDto.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDto> getAllProducts(){
        String productsUrl=fakeStoreUrl+fakeStorePathProducts;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto[]> productsResponse=restTemplate.getForEntity(productsUrl, FakeStoreProductResponseDto[].class);
        return List.of(productsResponse.getBody());
    }

    public FakeStoreProductResponseDto addProduct(FakeStoreProductRequestDto fakeStoreProductRequestDto){
        String productsUrl=fakeStoreUrl+fakeStorePathProducts;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto> productResponse=restTemplate.postForEntity(productsUrl,fakeStoreProductRequestDto, FakeStoreProductResponseDto.class);
        return productResponse.getBody();
    }

//    public FakeStoreProductResponseDto updateProduct(FakeStoreProductRequestDto fakeStoreProductRequestDto){
//        String productsUrl=fakeStoreUrl+fakeStorePathProducts;
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductResponseDto> response=restTemplate.patchForObject(productsUrl,fakeStoreProductRequestDto, FakeStoreProductResponseDto.class);
//        return response.getBody();
//    }

}
