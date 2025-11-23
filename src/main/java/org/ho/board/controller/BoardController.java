package org.ho.board.controller;

import lombok.RequiredArgsConstructor;
import org.ho.board.dto.BoardRequestDto;
import org.ho.board.dto.BoardResponseDto;
import org.ho.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @PostMapping
  public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
    return boardService.saveBoard(requestDto);
  }

  @GetMapping("/{id}")
  public BoardResponseDto getBoard(@PathVariable Long id) {
    return boardService.getDetailedBoard(id);
  }

  @GetMapping
  public List<BoardResponseDto> getBoardList() {
    return boardService.getListBoard();
  }

  @PutMapping("/{id}")
  public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
    return boardService.updateBoard(id, requestDto);
  }

  @DeleteMapping("/{id}")
  public void deleteBoard(@PathVariable Long id) {
    boardService.deleteBoard(id);
  }
}