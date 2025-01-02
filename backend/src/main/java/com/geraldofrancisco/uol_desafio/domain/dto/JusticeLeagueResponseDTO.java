package com.geraldofrancisco.uol_desafio.domain.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class JusticeLeagueResponseDTO {

  private List<String> names;
}
