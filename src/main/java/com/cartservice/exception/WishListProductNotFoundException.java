package com.cartservice.exception;

public class WishListProductNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;


    public WishListProductNotFoundException(String msg){

        super(msg);

    }
}
