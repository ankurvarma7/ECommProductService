package com.project.ecommproductservice.services;

import com.project.ecommproductservice.client.FakeStoreProductClient;
import com.project.ecommproductservice.dtos.FakeStoreProductRequestDto;
import com.project.ecommproductservice.dtos.FakeStoreProductResponseDto;
import com.project.ecommproductservice.dtos.ProductServiceRequestDto;
import com.project.ecommproductservice.dtos.ProductServiceResponseDto;
import com.project.ecommproductservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.project.ecommproductservice.mapper.DtoMapper.fakeStoreProductResponseDtoToProductServiceResponseDto;
import static com.project.ecommproductservice.mapper.DtoMapper.productServiceRequestDtoToFakeStoreProductRequestDto;
import static com.project.ecommproductservice.utils.ProductUtils.isNull;
@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private final FakeStoreProductClient fakeStoreProductClient;
    @Autowired
    public FakeStoreProductServiceImpl(FakeStoreProductClient fakeStoreProductClient){
        this.fakeStoreProductClient=fakeStoreProductClient;
    }
    @Override
    public ProductServiceResponseDto getProductById(int id) {
        FakeStoreProductResponseDto fakeStoreProductResponseDto=fakeStoreProductClient.getProductbyId(id);
        if(isNull(fakeStoreProductResponseDto)){
            throw new ProductNotFoundException("Product Not Found!!");
        }
        return fakeStoreProductResponseDtoToProductServiceResponseDto(fakeStoreProductResponseDto);
    }

    @Override
    public List<ProductServiceResponseDto> getProducts() {
        List<FakeStoreProductResponseDto> fakeStoreProductResponseDtos=fakeStoreProductClient.getAllProducts();
        List<ProductServiceResponseDto> productServiceResponseDtos=new ArrayList<>();
        for(FakeStoreProductResponseDto fakeStoreProductResponseDto:fakeStoreProductResponseDtos){
            productServiceResponseDtos.add(fakeStoreProductResponseDtoToProductServiceResponseDto(fakeStoreProductResponseDto));
        }
        return productServiceResponseDtos;
    }

    @Override
    public ProductServiceResponseDto addProduct(ProductServiceRequestDto productServiceRequestDto) {
        FakeStoreProductRequestDto fakeStoreProductRequestDto=productServiceRequestDtoToFakeStoreProductRequestDto(productServiceRequestDto);
        FakeStoreProductResponseDto fakeStoreProductResponseDto= fakeStoreProductClient.addProduct(fakeStoreProductRequestDto);
        return fakeStoreProductResponseDtoToProductServiceResponseDto(fakeStoreProductResponseDto);
    }

    @Override
    public ProductServiceResponseDto updateProduct(ProductServiceRequestDto productServiceRequestDto) {
        return null;
    }

    @Override
    public boolean deleteProduct(ProductServiceRequestDto productServiceRequestDto) {
        return false;
    }
}
