package com.farmstory.responsedto.product;

import com.farmstory.entity.product.ProductEntity;
import com.farmstory.entity.product.ProductFileEntity;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GetProductRespDto {
    private Long prodIdx;

    private String prodName;

    private BigDecimal prodDelivery;

    private BigDecimal prodPrice;

    private BigDecimal prodDiscount;

    private BigDecimal prodSavePoint;

    private Timestamp prodCreateAt;

    private String prodEtc;

    List<GetProductFileRespDto> files;

}
