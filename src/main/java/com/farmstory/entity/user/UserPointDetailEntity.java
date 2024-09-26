package com.farmstory.entity.user;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "user_point_detail")
@Getter
@NoArgsConstructor
public class UserPointDetailEntity {

    @Id
    @Column(name = "point_detail_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointDetailIdx;

    @Column(name = "save_point", nullable = true) // Default is nullable
    private BigDecimal savePoint;

    @Column(name = "use_point", nullable = true) // Default is nullable
    private BigDecimal usePoint;

    @ManyToOne
    @JoinColumn(name = "point_idx")
    private UserPointEntity point;
}
