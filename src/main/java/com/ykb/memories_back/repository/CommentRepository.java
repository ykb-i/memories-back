package com.ykb.memories_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ykb.memories_back.common.entity.CommentEntity;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
  
  List<CommentEntity> findByDiaryNumber(Integer diaryNumber);
  
  CommentEntity findByDiaryNumberAndCommentNumber(Integer diaryNumber, Integer commentNumber);
  @Transactional
  void deleteByDiaryNumber(Integer diaryNumber);
}
