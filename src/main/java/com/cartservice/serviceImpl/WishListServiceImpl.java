package com.cartservice.serviceImpl;

import com.cartservice.dto.WishListDto;
import com.cartservice.exception.CartNotFoundException;
import com.cartservice.exception.WishListProductNotFoundException;
import com.cartservice.model.Cart;
import com.cartservice.model.WishList;
import com.cartservice.repository.WishListRepository;
import com.cartservice.service.WishListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;
    @Override
    public WishList addWishList(WishListDto wishListDto) {

        Optional<WishList> doesExist = wishListRepository.findByUsernameAndProduct_Id(wishListDto.getUsername(), wishListDto.getProduct().getId());

        if (doesExist.isEmpty()){
            WishList newCart = new WishList();
            newCart.setUsername(wishListDto.getUsername());
            newCart.setProduct(wishListDto.getProduct());
            wishListRepository.save(newCart);
        }else {
            return doesExist.get();
        }
        return null;
    }

    @Override
    public List<WishList> getWishListProducts(String username) {
        return wishListRepository.findAllByUsername(username);
    }

    @Override
    public void removeItemFromWishList(String wishListId) {
        Optional<WishList> doesExist = wishListRepository.findById(wishListId);
        if (doesExist.isEmpty()){
            throw new WishListProductNotFoundException("Item not found for ID " + wishListId);
        }
        wishListRepository.deleteById(wishListId);
    }
}
