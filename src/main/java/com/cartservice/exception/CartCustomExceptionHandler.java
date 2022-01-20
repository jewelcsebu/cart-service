package com.cartservice.exception;

import com.cartservice.util.MethodUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartCustomExceptionHandler {


    @ExceptionHandler(value=CartNotFoundException.class)
    public ResponseEntity<String> productNotFoundExceptionException(CartNotFoundException exception){
        HttpStatus status=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(MethodUtils.prepareErrorJSON(status,exception),status);
    }

    @ExceptionHandler(value=WishListProductNotFoundException.class)
    public ResponseEntity<String> wishListPoductNotFoundExceptionException(WishListProductNotFoundException exception){
        HttpStatus status=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(MethodUtils.prepareErrorJSON(status,exception),status);
    }
}
