package com.farmstory.entity.cart;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_idx")
    private Long cartIdx;

    @Column(name = "user_idx", nullable = false)
    private Long userIdx;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<CartItemEntity> carts;

}
