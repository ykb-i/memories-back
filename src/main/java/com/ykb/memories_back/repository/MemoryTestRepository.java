package com.ykb.memories_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ykb.memories_back.common.entity.MemoryTestEntity;
import com.ykb.memories_back.common.entity.pk.MemoryTestPk;


@Repository
public interface MemoryTestRepository extends JpaRepository <MemoryTestEntity, MemoryTestPk>{

  Integer countByUserId(String userID);

  List<MemoryTestEntity> findByUserIdOrderBySequenceDesc(String userId);
  List<MemoryTestEntity> findTop10ByUserIdOrderBySequenceDesc(String userId);
  MemoryTestEntity findByUserIdAndSequence(String userId, Integer sequence);
}
