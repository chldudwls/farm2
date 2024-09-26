package com.farmstory.entity.board;

import com.farmstory.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx")
    private Long boardIdx;

    @Column(name = "board_title", nullable = false, length = 50)
    private String boardTitle;

    @Column(name = "board_content", nullable = false)
    private String boardContent;

    @Column(name = "board_view_cnt", nullable = false)
    @Builder.Default
    private Integer boardViewCnt =0;

    @Column(name = "board_section", nullable = false, length = 20)
    private String boardSection;

    @Column(name = "board_type", nullable = false, length = 20)
    private String boardType;

    @Column(name = "board_create_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp boardCreateAt;

    @Column(name = "board_modify_at", nullable = false)
    @CreationTimestamp
    private Timestamp boardModifyAt;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private UserEntity user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @Builder.Default
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @Builder.Default
    private List<BoardFileEntity> boardFiles = new ArrayList<>();

}
