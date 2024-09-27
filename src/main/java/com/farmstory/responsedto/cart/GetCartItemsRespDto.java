package com.farmstory.responsedto.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCartItemsRespDto {
    private Long cartItemIdx;
    private String prodFileName;
    private String prodFilePath;
    private String prodType;
    private String prodName;
    private Integer cartItemQuantity;
    private BigDecimal prodDiscount;
    private BigDecimal prodPoint;
    private BigDecimal prodPrice;
    private BigDecimal cartItemTotal;
}
