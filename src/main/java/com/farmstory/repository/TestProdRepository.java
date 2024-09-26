package com.farmstory.repository;

import com.farmstory.entity.TestProdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestProdRepository extends JpaRepository<TestProdEntity, Long> {
    List<TestProdEntity> findAll();
    List<TestProdEntity> findByType(String type);
}
