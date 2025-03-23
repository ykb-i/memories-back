package com.ykb.memories_back.common.dto.Response.test;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.entity.MemoryTestEntity;
import com.ykb.memories_back.common.vo.MemoryTestVO;

import lombok.Getter;

@Getter
public class GetMemoryResponseDto extends ResponseDto {

  private List<MemoryTestVO> memoryTests;

  private GetMemoryResponseDto(List<MemoryTestEntity> memoryTestEntities){
    this.memoryTests = MemoryTestVO.getList(memoryTestEntities);
  }

  public static ResponseEntity<GetMemoryResponseDto> success(List<MemoryTestEntity> memoryTestEntities) {
    GetMemoryResponseDto body = new GetMemoryResponseDto(memoryTestEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
