package com.cartservice.repository;


import com.cartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByCustomerIdAndProductId(Long customerId, int productId);
    List<Cart> findAllByCustomerId(long customerId);
}
