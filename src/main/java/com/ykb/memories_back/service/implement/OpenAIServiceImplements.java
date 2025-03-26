package com.ykb.memories_back.service.implement;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ykb.memories_back.service.OpenAIService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenAIServiceImplements implements OpenAIService {
  private final WebClient webClient;

  @Override
  public String chat() {
    String content = "삼성전자에 대해 알려줘";
    List<GptMessageVO> message = List.of(new GptMessageVO("user", content));

    ChatRequestDto requestBody = new ChatRequestDto("gpt-4o-mini", message);

    ChatResponseDto responseBody = webClient.post()
      .uri("/chat/completions")
      .bodyValue(requestBody)
      .retrieve()
      .bodyToMono(ChatResponseDto.class)
      .block();

    if (responseBody == null || responseBody.getChoices() == null || responseBody.getChoices().isEmpty()) {
      return null;
    }

    return responseBody.getChoices().get(0).getMessage().getContent();
  }
}
