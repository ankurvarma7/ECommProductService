package com.project.ecommproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceRequestDto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
