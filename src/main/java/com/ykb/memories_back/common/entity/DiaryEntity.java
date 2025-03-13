package com.ykb.memories_back.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="diary")
@Table(name="diary")
public class DiaryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diaryNumber;
    private String userId;
    private String writeDate;
    private String weather;
    private String feeling;
    private String title;
    private String content;

}
