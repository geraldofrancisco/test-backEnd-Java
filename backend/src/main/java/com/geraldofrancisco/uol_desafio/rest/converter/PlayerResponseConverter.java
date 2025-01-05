package com.geraldofrancisco.uol_desafio.rest.converter;

import com.geraldofrancisco.uol_desafio.domain.dto.player.PlayerDTO;
import com.geraldofrancisco.uol_desafio.rest.model.PlayerResponse;
import com.geraldofrancisco.uol_desafio.rest.model.PlayerResponsePage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerResponseConverter {
  public static PlayerResponsePage toPageResponse(PageImpl<PlayerDTO> page) {
    return PlayerResponsePage.builder()
        .page(page.getNumber())
        .items(toResponseList(page.getContent()))
        .totalPages(page.getTotalPages())
        .hasNext(page.hasNext())
        .isLast(page.isLast())
        .build();
  }

  private static List<PlayerResponse> toResponseList(List<PlayerDTO> content) {
    return content.stream().map(PlayerResponseConverter::toResponse).toList();
  }

  private static PlayerResponse toResponse(PlayerDTO dto) {
    return PlayerResponse.builder()
        .id(dto.getId())
        .email(dto.getEmail())
        .name(dto.getName())
        .phone(dto.getPhone())
        .codename(dto.getCodename())
        .creationDate(dto.getCreationDate())
        .type(dto.getType().getName())
        .build();
  }
}
