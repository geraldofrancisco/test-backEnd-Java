package com.geraldofrancisco.uol_desafio.domain.db;

import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
  @Id
  private Long id;

  @Column(value = "creation_date")
  private LocalDateTime creationDate;

  private String name;

  private String email;

  private String phone;

  private String codename;

  private PlayerType type;
}
