package com.geraldofrancisco.uol_desafio.domain.db;

import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
  @Id
  private Long id;

  private String name;

  private String email;

  private String phone;

  private String codename;

  private PlayerType type;
}
