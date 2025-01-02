package com.geraldofrancisco.uol_desafio.domain.dto.player;

import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
  private Long id;
  private LocalDateTime creationDate;
  private String name;
  private String email;
  private String phone;
  private String codename;
  private PlayerType type;
}
