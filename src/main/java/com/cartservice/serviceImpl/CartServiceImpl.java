package com.cartservice.serviceImpl;

import com.cartservice.dto.CartDto;
import com.cartservice.model.Cart;
import com.cartservice.repository.CartRepository;
import com.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {



    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addCart(CartDto cartDto) {


        Optional<Cart> doesExist = Optional.ofNullable(cartRepository.findByCustomerIdAndProductId(cartDto.getCustomerId(), cartDto.getProductId()));

        if (doesExist.isEmpty()){
            Cart newCart = new Cart();
            newCart.setCustomerId(cartDto.getCustomerId());
            newCart.setProductId(cartDto.getProductId());
            newCart.setQty(1);
            cartRepository.save(newCart);
        }

    }

    @Override
    public List<Cart> getCartProducts(long customerId) {
        return cartRepository.findAllByCustomerId(customerId);
    }
}
