package com.farmstory.responsedto.cart;

import com.farmstory.requestdto.TestCartRequestDto;
import com.farmstory.responsedto.ResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TestCartResponseDto implements ResponseDto {
    private String code;
    private String type;
    private String section;
    private TestCartRequestDto cartRequestDto;

}
