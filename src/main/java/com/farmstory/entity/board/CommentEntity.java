package com.farmstory.entity.board;

import com.farmstory.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@ToString
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_idx")
    private Long commentIdx;

//    @Column(name = "user_idx", nullable = false)
//    private Long userIdx;
//
//    @Column(name = "board_idx", nullable = false)
//    private Long boardIdx;

    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    @Column(name = "comment_view_cnt", nullable = false)
    @Builder.Default
    private Integer commentViewCnt = 0;

    @Column(name = "comment_create_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp commentCreateAt;

    @CreationTimestamp
    @Column(name = "comment_modify_at", nullable = false)
    private Timestamp commentModifyAt;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "board_idx")
    private BoardEntity board;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private UserEntity user;
}
