package com.geraldofrancisco.uol_desafio.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PlayerType {
  JUSTICE_LEAGUE("Liga da Justiça"),
  AVENGERS("Vingadores");

  private final String name;

  public static PlayerType getByName(final String value) {
    if(StringUtils.isBlank(value))
      return null;

    return Arrays.stream(PlayerType.values())
        .filter(p -> p.name().equals(value))
        .findFirst()
        .orElse(null);
  }
}
