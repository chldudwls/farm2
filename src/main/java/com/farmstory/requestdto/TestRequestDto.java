package com.farmstory.requestdto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestRequestDto {
    private int prodIdx;
    private int quantity;
    private String section;
    private String type;
    private Long boardIdx;
    private Long cartIdx;
    private String name;
    private String addr;
    private String user_name;
    private String user_email;
    private int cartItemQuantity;
}
