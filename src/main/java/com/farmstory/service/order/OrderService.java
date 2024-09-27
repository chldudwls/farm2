package com.farmstory.service.order;

import com.farmstory.entity.product.ProductEntity;
import com.farmstory.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;

    public ProductEntity getDirectView(Long prodIdx, Long cartItemQuantity) {

        Optional<ProductEntity> prod = productRepository.findById(prodIdx);
        if(prod.isPresent()) {

        }
        System.out.println(prod.get());

        return prod.get();
    }
}
