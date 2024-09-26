package com.farmstory.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "user_point")
@Getter
@NoArgsConstructor
public class UserPointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_idx")
    private Long pointIdx;

    @Column(name = "user_idx", nullable = false, unique = true)
    private Long userIdx;  // Foreign key without relationship mapping

    @Column(name = "user_point", nullable = false)
    private BigDecimal userPoint;

}
