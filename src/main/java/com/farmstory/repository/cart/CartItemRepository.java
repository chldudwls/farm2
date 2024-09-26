package com.farmstory.repository.cart;

import com.farmstory.entity.cart.CartEntity;
import com.farmstory.entity.cart.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity,Long> {
    List<CartItemEntity> findAllByCart(CartEntity cartEntity);
}
