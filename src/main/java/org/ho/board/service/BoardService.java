package org.ho.board.service;

import lombok.RequiredArgsConstructor;
import org.ho.board.domain.Board;
import org.ho.board.dto.BoardRequestDto;
import org.ho.board.dto.BoardResponseDto;
import org.ho.board.exception.BoardNotFoundException;
import org.ho.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

  private final BoardRepository boardRepository;

  @Transactional //메서드나 클래스 단위로 트랜잭션을 자동 관리
  public BoardResponseDto saveBoard(BoardRequestDto requestDto){
    Board board = new Board();
    board.setTitle(requestDto.getTitle());
    board.setContent(requestDto.getContent());
    board.setWriter(requestDto.getWriter());

    Board saved = boardRepository.save(board);
    return new BoardResponseDto(saved);
  }

  public BoardResponseDto getDetailedBoard(Long id){
    Board board = boardRepository.findById(id)
        .orElseThrow(() -> new BoardNotFoundException(id));
    return new BoardResponseDto(board);
  }

  public List<BoardResponseDto> getListBoard(){
    return boardRepository.findAll().stream()
        .map(BoardResponseDto::new)
        .collect(Collectors.toList());
  }

  @Transactional
  public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto){
    Board existBoard = boardRepository.findById(id)
        .orElseThrow(() -> new BoardNotFoundException(id));

    existBoard.setTitle(requestDto.getTitle());
    existBoard.setContent(requestDto.getContent());

    // writer typically doesn't change, but add if needed
    // existBoard.setWriter(requestDto.getWriter());

    return new BoardResponseDto(existBoard);
  }

  @Transactional
  public void deleteBoard(Long id){
    Board existBoard = boardRepository.findById(id)
        .orElseThrow(() -> new BoardNotFoundException(id));
    boardRepository.delete(existBoard);
  }
}