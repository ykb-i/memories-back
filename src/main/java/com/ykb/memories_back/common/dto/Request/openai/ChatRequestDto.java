package com.ykb.memories_back.common.dto.Request.openai;

import java.util.List;

import com.ykb.memories_back.common.vo.GptMessageVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequestDto {
  private String model;
  private List<GptMessageVO> messages;
}