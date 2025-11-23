package org.ho.board.dto;

import lombok.Getter;
import org.ho.board.domain.Board;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {
  private final Long id;
  private final String title;
  private final String content;
  private final String writer;
  private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;

  public BoardResponseDto(Board board) {
    this.id = board.getId();
    this.title = board.getTitle();
    this.content = board.getContent();
    this.writer = board.getWriter();
    this.createdAt = board.getCreatedAt();
    this.updatedAt = board.getUpdatedAt();
  }
}