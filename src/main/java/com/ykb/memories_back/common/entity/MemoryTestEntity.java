package com.ykb.memories_back.common.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.ykb.memories_back.common.dto.Request.test.PostMemoryRequestDto;
import com.ykb.memories_back.common.entity.pk.MemoryTestPk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="memoryTest")
@Table(name="memory_test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MemoryTestPk.class)
public class MemoryTestEntity {
    
    @Id
    private String userId;
    @Id
    private Integer sequence;
    private Integer measurementTime;
    private String testDate;
    private Integer gap;

    public MemoryTestEntity(PostMemoryRequestDto dto, String userId){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.userId = userId;
        this.sequence = 1;
        this.measurementTime = dto.getMeasurementTime();
        this.testDate = now.format(dateTimeFormatter);
    }

    public MemoryTestEntity(PostMemoryRequestDto dto, MemoryTestEntity preTestEntity, String userId){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.userId = userId;
        this.sequence = preTestEntity.getSequence() + 1;
        this.measurementTime = dto.getMeasurementTime();
        this.testDate = now.format(dateTimeFormatter);
        this.gap = dto.getMeasurementTime() - preTestEntity.getMeasurementTime();
    }
}
