package com.geraldofrancisco.uol_desafio.domain.converter;

import com.geraldofrancisco.uol_desafio.domain.db.Player;
import com.geraldofrancisco.uol_desafio.domain.dto.player.PlayerDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerConverter {

  public static Player toDomain(PlayerDTO dto) {
    return Player.builder()
        .email(dto.getEmail())
        .name(dto.getName())
        .codename(dto.getCodename())
        .type(dto.getType())
        .phone(dto.getPhone())
        .build();
  }

  public static PlayerDTO toDTO(Player domain) {
    return PlayerDTO.builder()
            .id(domain.getId())
            .phone(domain.getPhone())
            .creationDate(domain.getCreationDate())
            .email(domain.getEmail())
            .codename(domain.getCodename())
            .type(domain.getType())
            .name(domain.getName())
            .build();
  }
}
