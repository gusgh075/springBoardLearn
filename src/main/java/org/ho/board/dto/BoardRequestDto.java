package org.ho.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {
  private String title;
  private String content;
  private String writer;
}