package com.farmstory.service.cart;

import com.farmstory.entity.cart.CartEntity;
import com.farmstory.entity.cart.CartItemEntity;
import com.farmstory.entity.product.ProductEntity;
import com.farmstory.entity.user.UserEntity;
import com.farmstory.repository.cart.CartItemRepository;
import com.farmstory.repository.cart.CartRepository;
import com.farmstory.repository.product.ProductRepository;
import com.farmstory.repository.user.UserRepository;
import com.farmstory.requestdto.cart.PostCartItemReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Transactional
    public String insertCart(PostCartItemReqDto request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); //
        Optional<UserEntity> optUser = userRepository.findByUserId(username);

        CartEntity cartEntity = CartEntity.builder().userIdx(optUser.get().getUserIdx()).build();
        Optional<CartEntity> optCart = cartRepository.findByUserIdx(optUser.get().getUserIdx());
        if(!optCart.isPresent()) {
            CartEntity cart = cartRepository.save(cartEntity);
            Optional<ProductEntity> prod = productRepository.findById((long)request.getProdIdx());
            CartItemEntity cartItem = CartItemEntity.builder()
                    .cartItemQuantity(request.getCartItemQuantity())
                    .cart(cart)
                    .prod(prod.get())
                    .build();

            cartItemRepository.save(cartItem);
        }
        Optional<ProductEntity> prod = productRepository.findById((long)request.getProdIdx());
        CartItemEntity cartItem = CartItemEntity.builder()
                .cartItemQuantity(request.getCartItemQuantity())
                .cart(optCart.get())
                .prod(prod.get())
                .build();

        cartItemRepository.save(cartItem);


        return "SU";
    }
}
