package com.ykb.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.ykb.memories_back.common.dto.Request.test.PostConcentrationRequestDto;
import com.ykb.memories_back.common.dto.Request.test.PostMemoryRequestDto;
import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.dto.Response.test.GetConcentrationResponseDto;
import com.ykb.memories_back.common.dto.Response.test.GetMemoryResponseDto;
import com.ykb.memories_back.common.dto.Response.test.GetRecentlyConcentrationResponseDto;
import com.ykb.memories_back.common.dto.Response.test.GetRecentlyMemoryResponseDto;

public interface TestService {
  ResponseEntity<ResponseDto> postMemory(PostMemoryRequestDto dto, String userId);
  ResponseEntity<? super GetMemoryResponseDto> getMemory(String userId);
  ResponseEntity<ResponseDto> postConcentration(PostConcentrationRequestDto dto, String userId);
  ResponseEntity<? super GetConcentrationResponseDto> getConcentration(String userId);
  ResponseEntity<? super GetRecentlyMemoryResponseDto> getRecentlyMemory(String userId);
  ResponseEntity<? super GetRecentlyConcentrationResponseDto> getRecentlyConcentration(String userId);
}
