package com.ykb.memories_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ykb.memories_back.common.dto.Request.openai.GetWayRequestDto;
import com.ykb.memories_back.common.dto.Response.openai.GetWayResponseDto;
import com.ykb.memories_back.service.OpenAIService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/open-ai")
@RequiredArgsConstructor
public class OpenAIController {
  
  private final OpenAIService openAIService;

  @PostMapping("/way")
  public ResponseEntity<? super GetWayResponseDto> getWay(
    @RequestBody @Valid GetWayRequestDto requestBody,
    @AuthenticationPrincipal String userId
  ) {
    return openAIService.getWay(requestBody, userId);
  }

}