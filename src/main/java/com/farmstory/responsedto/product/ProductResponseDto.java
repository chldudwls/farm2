package com.farmstory.responsedto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDto {
    private String html;
    private String productName;  // 상품명
    private String productCode;  // 상품 코드
    private String deliveryCost; // 배송비
    private String salePrice;    // 판매가격
    private String quantity;     // 구매수량
    private String totalAmount;
}
