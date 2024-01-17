package com.project.ecommproductservice.controllers.controlleradvice;

import com.project.ecommproductservice.dtos.ErrorResponseDto;
import com.project.ecommproductservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(value=ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProductNotFoundException(ProductNotFoundException pnfe){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto();
        errorResponseDto.setMessage(pnfe.getMessage());
        errorResponseDto.setMessageCode(404);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
