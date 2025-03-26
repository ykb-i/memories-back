package com.ykb.memories_back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.ykb.memories_back.service.OpenAIService;
=======
import com.sjh.memories_back.service.OpenAIService;
>>>>>>> 8d5ae391bc2a3291e1b797dffecb6c49ed0a82a7

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/open-ai")
@RequiredArgsConstructor
public class OpenAIController {
  
  private final OpenAIService openAIService;

  @GetMapping("")
  public String chat() {
    return openAIService.chat();
  }

}