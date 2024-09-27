package com.farmstory.service.order;

import com.farmstory.entity.order.OrderEntity;
import com.farmstory.entity.order.OrderItemEntity;
import com.farmstory.entity.product.ProductEntity;
import com.farmstory.repository.order.OrderItemRepository;
import com.farmstory.repository.order.OrderRepository;
import com.farmstory.repository.product.ProductRepository;
import com.farmstory.requestdto.order.OderReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public ProductEntity getDirectView(Long prodIdx, Long cartItemQuantity) {

        Optional<ProductEntity> prod = productRepository.findById(prodIdx);
        if(prod.isPresent()) {

        }
        System.out.println(prod.get());

        return prod.get();
    }

    public void insertOrder(OderReqDTO request) {
        Optional<ProductEntity>  optProduct = productRepository.findById(request.getProdIdx());
        OrderEntity orderEntity = request.toOrderEntity(optProduct.get());
        orderRepository.save(orderEntity);

//        OrderItemEntity orderItemEntity = request.toOrderItemEntity();
//        orderItemRepository.save(orderItemEntity);
    }
}
