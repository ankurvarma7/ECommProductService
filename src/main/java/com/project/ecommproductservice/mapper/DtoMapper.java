package com.project.ecommproductservice.mapper;

import com.project.ecommproductservice.dtos.FakeStoreProductRequestDto;
import com.project.ecommproductservice.dtos.FakeStoreProductResponseDto;
import com.project.ecommproductservice.dtos.ProductServiceRequestDto;
import com.project.ecommproductservice.dtos.ProductServiceResponseDto;

public class DtoMapper {
    public static ProductServiceResponseDto fakeStoreProductResponseDtoToProductServiceResponseDto(FakeStoreProductResponseDto fakeStoreProductResponseDto){
        ProductServiceResponseDto productServiceResponseDto=new ProductServiceResponseDto();
        productServiceResponseDto.setId(fakeStoreProductResponseDto.getId());
        productServiceResponseDto.setCategory(fakeStoreProductResponseDto.getCategory());
        productServiceResponseDto.setDescription(fakeStoreProductResponseDto.getDescription());
        productServiceResponseDto.setTitle(fakeStoreProductResponseDto.getTitle());
        productServiceResponseDto.setPrice(fakeStoreProductResponseDto.getPrice());
        productServiceResponseDto.setImage(fakeStoreProductResponseDto.getImage());
        return productServiceResponseDto;
    }

    public static FakeStoreProductRequestDto productServiceRequestDtoToFakeStoreProductRequestDto(ProductServiceRequestDto productServiceRequestDto){
        FakeStoreProductRequestDto fakeStoreProductRequestDto=new FakeStoreProductRequestDto();
        fakeStoreProductRequestDto.setCategory(productServiceRequestDto.getCategory());
        fakeStoreProductRequestDto.setDescription(productServiceRequestDto.getDescription());
        fakeStoreProductRequestDto.setTitle(productServiceRequestDto.getTitle());
        fakeStoreProductRequestDto.setPrice(productServiceRequestDto.getPrice());
        fakeStoreProductRequestDto.setImage(productServiceRequestDto.getImage());
        return fakeStoreProductRequestDto;
    }
}
