package com.cartservice.serviceImpl;

import com.cartservice.dto.CartDto;
import com.cartservice.exception.CartNotFoundException;
import com.cartservice.model.Cart;
import com.cartservice.repository.CartRepository;
import com.cartservice.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;

    @Override
    public Cart addCart(CartDto cartDto) {

        Optional<Cart> doesExist = cartRepository.findByUsernameAndProduct_Id(cartDto.getUsername(), cartDto.getProduct().getId());

        if (doesExist.isEmpty()){
            Cart newCart = new Cart();
            cartDto.getProduct().setQuantity(1);
            newCart.setUsername(cartDto.getUsername());
            newCart.setProduct(cartDto.getProduct());
            cartRepository.save(newCart);
        }else {
            return doesExist.get();
        }
      return null;
    }

//    @Override
//    public List<Cart> getCartProducts(long customerId) {
//        return cartRepository.findAllByUserId(customerId);
//    }

    @Override
    public List<Cart> getCartProducts(String username) {
        return cartRepository.findAllByUsername(username);
    }

    @Override
    public void removeItemFromCart(String cartId) {
        Optional<Cart> doesExist = cartRepository.findById(cartId);
        if (doesExist.isEmpty()){
            throw new CartNotFoundException("Cart Item not found for ID " + cartId);
        }
         cartRepository.deleteById(cartId);
    }

    @Override
    public void incrementQtyById(String cartId) {
        Optional<Cart> doesExist = cartRepository.findById(cartId);
        if (doesExist.isPresent()){
            doesExist.get().getProduct().setQuantity(doesExist.get().getProduct().getQuantity()+1);
            cartRepository.save(doesExist.get());
        }else {
            throw new CartNotFoundException("Cart Item not found for ID " + cartId);
        }
    }

    @Override
    public void decrementQtyById(String cartId) {
        Optional<Cart> doesExist = cartRepository.findById(cartId);
        if (doesExist.isPresent()){
            doesExist.get().getProduct().setQuantity(doesExist.get().getProduct().getQuantity()-1);
            cartRepository.save(doesExist.get());
        }else {
            throw new CartNotFoundException("Cart Item not found for ID " + cartId);
        }
    }


}
