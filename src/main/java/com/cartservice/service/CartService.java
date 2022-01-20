package com.cartservice.service;

import com.cartservice.dto.CartDto;
import com.cartservice.model.Cart;

import java.util.List;

public interface CartService {
    Cart addCart(CartDto cartDto);
//    List<Cart> getCartProducts(long customerId);
    List<Cart> getCartProducts(String username);
    void removeItemFromCart(String cartId);
    void incrementQtyById(String cartId);
    void decrementQtyById(String cartId);
}
