package com.cartservice.controller;


import com.cartservice.dto.CartDto;
import com.cartservice.model.Cart;
import com.cartservice.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cart-service")
public class CartController {

    private final CartService cartService;


    @PostMapping("/add-to-cart")
    public ResponseEntity<Cart> addToCart(@RequestBody CartDto cartDto){
        return new ResponseEntity<>(cartService.addCart(cartDto),HttpStatus.OK);
    }


//    @GetMapping("/get/cart-products/{customerId}")
//    public ResponseEntity<List<Cart>> getCartProducts(@PathVariable long customerId){
//        return new ResponseEntity<>(cartService.getCartProducts(customerId),HttpStatus.OK);
//    }

    @GetMapping("/get/cart-products/{username}")
    public ResponseEntity<List<Cart>> getCartProducts(@PathVariable String username){
        return new ResponseEntity<>(cartService.getCartProducts(username),HttpStatus.OK);
    }


    @GetMapping("/remove/cart-item/{cartId}")
    public void removeCart(@PathVariable String cartId){
        cartService.removeItemFromCart(cartId);
    }

    @GetMapping("/cart/qty-increment/{cartId}")
    public void incrementQty(@PathVariable String cartId){
        cartService.incrementQtyById(cartId);
    }
    @GetMapping("/cart/qty-decrement/{cartId}")
    public void decrementQty(@PathVariable String cartId){
        cartService.decrementQtyById(cartId);
    }


}
