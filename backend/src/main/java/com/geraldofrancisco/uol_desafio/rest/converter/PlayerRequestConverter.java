package com.geraldofrancisco.uol_desafio.rest.converter;

import com.geraldofrancisco.uol_desafio.domain.dto.player.PlayerDTO;
import com.geraldofrancisco.uol_desafio.domain.enums.PlayerType;
import com.geraldofrancisco.uol_desafio.rest.model.PlayerCreateRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerRequestConverter {
    public static PlayerDTO toDTO(PlayerCreateRequest request) {
    return PlayerDTO.builder()
        .name(request.getName())
        .email(request.getEmail())
        .phone(request.getPhone())
        .type(PlayerType.getByName(request.getType()))
        .build();
    }
}
