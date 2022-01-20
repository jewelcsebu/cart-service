package com.cartservice.controller;


import com.cartservice.dto.CartDto;
import com.cartservice.dto.WishListDto;
import com.cartservice.model.Cart;
import com.cartservice.model.WishList;
import com.cartservice.service.WishListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cart-service")
public class WishListController {

    private final WishListService wishListService;

    @PostMapping("/add-to-wish-list")
    public ResponseEntity<WishList> addToWishList(@RequestBody WishListDto wishListDto){
        return new ResponseEntity<>(wishListService.addWishList(wishListDto),HttpStatus.OK);
    }


    @GetMapping("/get/wish-list-products/{username}")
    public ResponseEntity<List<WishList>> getWishListProducts(@PathVariable String username){
        return new ResponseEntity<>(wishListService.getWishListProducts(username),HttpStatus.OK);
    }

    @GetMapping("/remove/wish-list-item/{wishListId}")
    public void removeWishListItem(@PathVariable String wishListId){
        wishListService.removeItemFromWishList(wishListId);
    }
}
