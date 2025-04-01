package com.ykb.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.ykb.memories_back.common.dto.Request.openai.ChatRequestDto;
import com.ykb.memories_back.common.dto.Request.openai.GetWayRequestDto;
import com.ykb.memories_back.common.dto.Response.openai.ChatResponseDto;
import com.ykb.memories_back.common.dto.Response.openai.GetWayResponseDto;

public interface OpenAIService {
  ResponseEntity<? super GetWayResponseDto> getWay(GetWayRequestDto dto, String userId);
  ResponseEntity<ChatResponseDto> chat(ChatRequestDto dto);
}