package com.farmstory.entity.order;

import com.farmstory.entity.cart.CartItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_idx")
    private Long orderitemIdx;

//    @Column(name = "order_idx")
//    private Long orderIdx;
//
//    @Column(name = "cart_item_idx")
//    private Long cartitemIidx;

    @ManyToOne
    @JoinColumn(name = "order_idx")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "cart_item_idx")
    private CartItemEntity cartItem;

}
