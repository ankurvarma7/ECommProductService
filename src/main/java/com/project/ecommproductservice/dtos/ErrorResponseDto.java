package com.project.ecommproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    private String message;
    private int messageCode;
}
