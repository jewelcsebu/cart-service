package com.cartservice.repository;


import com.cartservice.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {
    Optional<Cart> findByUsernameAndProduct_Id(String username, int productId);
    List<Cart> findAllByUsername(String username);
}
