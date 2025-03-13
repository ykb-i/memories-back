package com.ykb.memories_back.common.entity.pk;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Serializable: 네트워크로 정보를 전송하고 클래스의 버전을 관리할 수 있게 해줌
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoryTestPk implements Serializable{
    @Column(name="user_id")
    private String userId;
    @Column(name="sequence")
    private Integer sequence;
}
