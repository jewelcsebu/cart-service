package com.cartservice.service;

import com.cartservice.dto.CartDto;
import com.cartservice.model.Cart;

import java.util.List;

public interface CartService {
    void addCart(CartDto cartDto);
    List<Cart> getCartProducts(long customerId);
}
