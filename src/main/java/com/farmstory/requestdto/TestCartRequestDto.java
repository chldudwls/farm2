package com.farmstory.requestdto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TestCartRequestDto {
    private Long test_prod_idx;
    private int test_cart_quantity;
    private BigDecimal test_cart_total_price;
}
