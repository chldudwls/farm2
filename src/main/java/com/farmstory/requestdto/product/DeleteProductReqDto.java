package com.farmstory.requestdto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteProductReqDto {
    private List<String> prodIdx;
}
