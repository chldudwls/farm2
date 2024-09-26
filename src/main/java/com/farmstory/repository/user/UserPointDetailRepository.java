package com.farmstory.repository.user;

import com.farmstory.entity.user.UserPointDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPointDetailRepository extends JpaRepository<UserPointDetailEntity,Long> {
}
