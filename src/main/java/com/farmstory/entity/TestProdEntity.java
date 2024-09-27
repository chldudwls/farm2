package com.farmstory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "test_prod")
public class TestProdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_idx")
    private Long prodIdx;

    @Column(nullable = false, length = 10)
    private String section;

    @Column(length = 10)
    private String type;

    @Column(nullable = false, length = 20)
    private String prodName;

    @Column(nullable = false)
    private BigDecimal prodPrice;


}
