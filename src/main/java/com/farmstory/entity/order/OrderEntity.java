package com.farmstory.entity.order;
import com.farmstory.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "`order`")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_idx")
    private Long orderIdx;

    @Column(name = "order_quantity")
    private int orderQuantity;

    @Column(name = "reciever_name", nullable = false, length = 20)
    private String recieverName;

    @Column(name = "reciever_hp", nullable = false, length = 20)
    private String recieverHp;

    @Column(name = "reciever_addr", nullable = false, length = 255)
    private String reciever_addr;

    @Column(name = "order_buying_type", nullable = false, length = 10)
    private String orderBuyingType;

    @Column(name = "order_save_point", nullable = false)
    private BigDecimal orderSavePoint;

    @Column(name = "order_etc")
    private String orderEtc;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private UserEntity user;
}
