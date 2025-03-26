package com.ykb.memories_back.common.entity.pk;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpathyPk {
  @Column(name = "user_id")
  private String userId;
  @Column(name = "diary_number")
  private Integer diaryNumber;
}
