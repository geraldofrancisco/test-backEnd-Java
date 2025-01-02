package com.geraldofrancisco.uol_desafio.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlayerType {
    JUSTICE_LEAGUE("Liga da Justiça"),
    AVENGERS("Vingadores");

    private final String name;
}
