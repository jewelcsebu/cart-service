package com.cartservice.service;

import com.cartservice.dto.WishListDto;
import com.cartservice.model.WishList;

import java.util.List;

public interface WishListService {
    WishList addWishList(WishListDto wishListDto);
    List<WishList> getWishListProducts(String username);
    void removeItemFromWishList(String wishListId);
}
