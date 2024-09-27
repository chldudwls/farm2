package com.farmstory.entity.board;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board_file")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_file_idx")
    private Long boardFileIdx;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "filepath", nullable = false)
    private String filepath;

    @ManyToOne
    @JoinColumn(name = "board_idx")
    private BoardEntity board;


}
