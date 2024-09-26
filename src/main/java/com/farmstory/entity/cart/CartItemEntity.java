package com.farmstory.entity.cart;
import com.farmstory.entity.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_item")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_idx")
    private Long cartItemIdx;

    @Column(name = "cart_item_quantity", nullable = false)
    private Integer cartItemQuantity;

    @ManyToOne
    @JoinColumn(name = "cart_idx")
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "prod_idx")
    private ProductEntity prod;
}
