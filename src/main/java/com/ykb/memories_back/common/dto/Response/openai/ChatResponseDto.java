package com.ykb.memories_back.common.dto.Response.openai;

import java.util.List;

import com.ykb.memories_back.common.vo.GptChoiceVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponseDto {
  private List<GptChoiceVO> choices;
}