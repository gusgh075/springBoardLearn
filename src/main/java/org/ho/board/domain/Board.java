package org.ho.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;
  private String writer;
  @CreationTimestamp //DB에 처음 저장될 때 자동으로 현재 시간 기록
  private LocalDateTime createdAt;
  @UpdateTimestamp //DB에 업데이트 될 때마다 자동으로 현재 시간 기록
  private LocalDateTime updatedAt;

}
