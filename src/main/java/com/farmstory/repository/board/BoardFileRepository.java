package com.farmstory.repository.board;

import com.farmstory.entity.board.BoardEntity;
import com.farmstory.entity.board.BoardFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardFileRepository extends JpaRepository<BoardFileEntity,Long> {
    void deleteByBoard(BoardEntity board);
}
