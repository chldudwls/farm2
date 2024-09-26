package com.farmstory.repository.board;

import com.farmstory.entity.board.BoardEntity;
import com.farmstory.entity.board.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    void deleteByBoard(BoardEntity board);
}
