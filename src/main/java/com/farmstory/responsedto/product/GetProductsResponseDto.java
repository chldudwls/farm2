package com.farmstory.responsedto.product;

import com.farmstory.responsedto.ResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductsResponseDto implements ResponseDto {
    private String code;
    private String section;
    private String type;
    public GetProductsResponseDto(String code) {
        this.code = code;
    }
}
