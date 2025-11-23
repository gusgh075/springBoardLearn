package org.ho.board.exception;

public class BoardNotFoundException extends RuntimeException {
  public BoardNotFoundException(Long id) {
    super("게시글 " + id + " 없음");
  }
}