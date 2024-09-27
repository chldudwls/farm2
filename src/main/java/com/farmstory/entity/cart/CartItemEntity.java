package com.farmstory.entity.cart;
import com.farmstory.entity.product.ProductEntity;
import com.farmstory.entity.product.ProductFileEntity;
import com.farmstory.responsedto.cart.GetCartItemsRespDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    public GetCartItemsRespDto toGetCartItemsRespDto() {
//        ProductFileEntity prodFile = prod.getProductFiles().stream()
//                .filter(v->v.getProdFileType().equals("list"))
//                .findFirst()
//                .orElse(null);
//        String fileName;
//
//        if(prodFile.getProdFileName()==null){
//            fileName = "empty.png";
//        } else {
//            fileName = prodFile.getProdFileName();
//        }

        BigDecimal totalPrice = BigDecimal.valueOf(cartItemQuantity).multiply(prod.getProdPrice());

        return GetCartItemsRespDto.builder()
                .cartItemIdx(cartItemIdx)
                //.prodFileName(fileName)
                .prodFilePath("/file/")
                .prodType(prod.getProdType())
                .prodName(prod.getProdName())
                .prodPoint(prod.getProdSavePoint())
                .cartItemQuantity(cartItemQuantity)
                .prodDiscount(prod.getProdDiscount())
                .prodPrice(prod.getProdPrice())
                .cartItemTotal(totalPrice)
                .build();
    }
}
