package com.cartservice.controller;


import com.cartservice.dto.CartDto;
import com.cartservice.model.Cart;
import com.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart-service")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/add-to-cart")
    public void addToCart(@RequestBody CartDto cartDto){
        cartService.addCart(cartDto);
    }

    @GetMapping("/get/cart-products/{customerId}")
    public ResponseEntity<List<Cart>> getCartProducts(@PathVariable long customerId){
        return new ResponseEntity<>(cartService.getCartProducts(customerId),HttpStatus.OK);
    }
}
