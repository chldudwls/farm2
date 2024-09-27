package com.farmstory.repository;

import com.farmstory.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<UserEntity ,Long>  {
    public UserEntity findByUserName(String username);
}
