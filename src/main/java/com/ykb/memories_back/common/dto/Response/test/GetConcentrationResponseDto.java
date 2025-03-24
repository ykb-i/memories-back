package com.ykb.memories_back.common.dto.Response.test;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.entity.ConcentrationTestEntity;
import com.ykb.memories_back.common.vo.ConcentrationTestVO;

import lombok.Getter;

@Getter
public class GetConcentrationResponseDto extends ResponseDto{
  
  private List<ConcentrationTestVO> concentrationTests;

  private GetConcentrationResponseDto(List<ConcentrationTestEntity> concentrationTestEntities){
    this.concentrationTests = ConcentrationTestVO.getList(concentrationTestEntities);
  }

  public static ResponseEntity<GetConcentrationResponseDto> success(List<ConcentrationTestEntity> concentrationTestEntities){
    GetConcentrationResponseDto body = new GetConcentrationResponseDto(concentrationTestEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
