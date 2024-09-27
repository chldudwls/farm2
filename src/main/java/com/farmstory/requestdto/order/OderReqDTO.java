package com.farmstory.requestdto.order;

import com.farmstory.entity.order.OrderEntity;
import com.farmstory.entity.order.OrderItemEntity;
import com.farmstory.entity.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OderReqDTO {

    private long prodIdx;
    private int cartItemQuantity;
    private String orderReciever;
    private String orderHp;
    private String orderAddr;
    private String buyingType;
    private String etc;

    public OrderEntity toOrderEntity(ProductEntity prod) {


        return OrderEntity.builder()
                .orderQuantity(1)
                .orderSavePoint(prod.getProdSavePoint())
                .recieverName(orderReciever)
                .recieverHp(orderHp)
                .reciever_addr(orderAddr)
                .orderBuyingType(buyingType)
                .orderEtc(etc)
                .build();
    }

//    public OrderItemEntity toOrderItemEntity(ProductEntity prod) {
//
//        return  OrderItemEntity.builder()
//                .order()
//                .build();
//    }
}
