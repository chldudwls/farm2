package com.farmstory.repository.user;

import com.farmstory.entity.user.UserPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPointRepository extends JpaRepository<UserPointEntity,Long> {
    UserPointEntity findByUserIdx(Long userIdx);
}
