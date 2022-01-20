package com.cartservice.repository;

import com.cartservice.model.WishList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface WishListRepository extends MongoRepository<WishList,String> {
    Optional<WishList> findByUsernameAndProduct_Id(String username, int id);
    List<WishList> findAllByUsername(String username);
}
